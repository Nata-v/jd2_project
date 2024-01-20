package by.nata.data.dao;

import by.nata.data.entity.Client;

import by.nata.data.entity.ClientAddress;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Role;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {
    private static final Logger log = LoggerFactory.getLogger(ClientDaoImpl.class);
    private final SessionFactory sessionFactory;


    public ClientDaoImpl(@Autowired SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

//    @Override
//    public Client findByUsername(String username) {
////        return sessionFactory.getCurrentSession()
////                .createQuery("from Client au where au.username=:username", Client.class)
////                .setParameter("username", username)
////                .list();





    @Override
    public ClientDto findByUsername(String username) {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "from Client WHERE username = :username";
        Query<Client> query = session.createQuery(hql, Client.class);
        query.setParameter("username", username);
        Client client = query.uniqueResult();

        if (client != null) {
            return convertToDto(client);
        }

        return null;
    }
    private ClientDto convertToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole(),
                convertToDto(client.getClientDetails()),
                convertToDto(client.getClientAddress())
        );
    }

    private ClientDetailsDto convertToDto(ClientDetails clientDetails) {

        return new ClientDetailsDto(clientDetails.getId(),
                            clientDetails.getSurname(),
                            clientDetails.getName(),
                            clientDetails.getBirthDate(),
                            clientDetails.getPassportNumber(),
                            clientDetails.getIdentityNumber(),
                            clientDetails.getDateIssue(),
                            clientDetails.getDateExpiry());
    }

    private ClientAddressDto convertToDto(ClientAddress clientAddress) {
        return new ClientAddressDto(clientAddress.getId(),
                            clientAddress.getCountry(),
                            clientAddress.getCity(),
                            clientAddress.getStreet(),
                            clientAddress.getHouseNumber(),
                            clientAddress.getFlatNumber(),
                            clientAddress.getPhoneNumber());
    }


    @Override
    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.find(Client.class, id));
        session.flush();
    }

    @Override
    public void update(ClientDto clientDto, ClientDetailsDto clientDetailsDto, ClientAddressDto clientAddressDto) {
        final Session session = sessionFactory.getCurrentSession();

        ClientDetails clientDetails = new ClientDetails();
        clientDetails.setSurname(clientDetailsDto.getSurname());
        clientDetails.setName(clientDetailsDto.getName());
        clientDetails.setBirthDate(clientDetailsDto.getBirthDate());
        clientDetails.setPassportNumber(clientDetails.getPassportNumber());
        clientDetails.setIdentityNumber(clientDetails.getIdentityNumber());
        clientDetails.setDateIssue(clientDetails.getDateIssue());
        clientDetails.setDateExpiry(clientDetails.getDateExpiry());

        ClientAddress clientAddress = new ClientAddress();
        clientAddress.setCountry(clientAddressDto.getCountry());
        clientAddress.setCity(clientAddressDto.getCity());
        clientAddress.setStreet(clientAddressDto.getStreet());
        clientAddress.setHouseNumber(clientAddressDto.getHouseNumber());
        clientAddress.setFlatNumber(clientAddressDto.getFlatNumber());
        clientAddress.setPhoneNumber(clientAddressDto.getPhoneNumber());

        Client client = new Client();
        client.setUsername(clientDto.getUsername());
        client.setPassword(clientDto.getPassword());
        client.setEmail(clientDto.getEmail());
        client.setClientDetails(clientDetails);
        client.setClientAddress(clientAddress);

        session.saveOrUpdate(clientDetails);
        session.saveOrUpdate(clientAddress);
        session.saveOrUpdate(client);
    }


    @Override
    public Client getClientById(String id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Client WHERE id = :id";
        Query<Client> query = session.createQuery(hql, Client.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    @Override
    @Transactional //(readOnly = true)
    public Optional<ClientDto> findById(String id) {
        final Session session = sessionFactory.getCurrentSession();
        // return Optional.ofNullable(session.find(ClientDto.class, id));

        ClientDetails clientDetails = session.find(ClientDetails.class, id);
        ClientAddress clientAddress = session.find(ClientAddress.class, id);
        Client client = session.find(Client.class, id);

        return Optional.of(new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole(),
                new ClientDetailsDto(clientDetails.getId(),
                        clientDetails.getSurname(),
                        clientDetails.getName(),
                        clientDetails.getBirthDate(),
                        clientDetails.getPassportNumber(),
                        clientDetails.getIdentityNumber(),
                        clientDetails.getDateIssue(),
                        clientDetails.getDateExpiry()),
                new ClientAddressDto(clientAddress.getId(),
                        clientAddress.getCountry(),
                        clientAddress.getCity(),
                        clientAddress.getStreet(),
                        clientAddress.getHouseNumber(),
                        clientAddress.getFlatNumber(),
                        clientAddress.getPhoneNumber())));
    }


    @Override
    public List<ClientDto> findAll() {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT new by.nata.data.entity.Client(c.id, c.username, c.password, c.email, c.role, c.clientDetails, c.clientAddress) FROM Client c";
        Query<Client> query = session.createQuery(hql, Client.class);
        List<Client> clients = query.getResultList();

        List<ClientDto> clientDtos = new ArrayList<>();

        for (Client client : clients) {
            clientDtos.add(convertToDto(client));
        }

        return clientDtos;
    }




    @Override

    public void save(ClientDto clientDto) {
        final Session session = sessionFactory.getCurrentSession();

        ClientDetailsDto clientDetailsDto = clientDto.getClientDetailsDto();
        ClientAddressDto clientAddressDto = clientDto.getClientAddressDto();

        ClientDetails clientDetails = new ClientDetails(
                clientDetailsDto.getId(),
                clientDetailsDto.getSurname(),
                clientDetailsDto.getName(),
                clientDetailsDto.getBirthDate(),
                clientDetailsDto.getPassportNumber(),
                clientDetailsDto.getIdentityNumber(),
                clientDetailsDto.getDateIssue(),
                clientDetailsDto.getDateExpiry()
        );

        ClientAddress clientAddress = new ClientAddress(
                clientAddressDto.getId(),
                clientAddressDto.getCountry(),
                clientAddressDto.getCity(),
                clientAddressDto.getStreet(),
                clientAddressDto.getHouseNumber(),
                clientAddressDto.getFlatNumber(),
                clientAddressDto.getPhoneNumber()
        );
        Client client = new Client(
                clientDto.getId(),
                clientDto.getUsername(),
                clientDto.getPassword(),
                clientDto.getEmail(),
                Role.USER,
               clientDetails,
                clientAddress);


session.save(clientDetails);
session.save(clientAddress);
        session.save(client);
log.info("Client saved: {}", client);


    }
}
