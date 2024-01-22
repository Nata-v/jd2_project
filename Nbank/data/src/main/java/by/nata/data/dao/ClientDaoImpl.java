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
    public void deleteClientById(String id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "DELETE FROM Client WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        if (result > 0) {
            session.flush();
        }
    }

    @Override
    public void save(ClientDto clientDto) {
        final Session session = sessionFactory.getCurrentSession();

        Client client = convertToEntity(clientDto);
        session.save(client);
        log.info("Client saved: {}", client);
    }

    private Client convertToEntity(ClientDto clientDto) {
        if (clientDto == null) {
            throw new IllegalArgumentException("ClientDto cannot be null");
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setUsername(clientDto.getUsername());
        client.setPassword(clientDto.getPassword());
        client.setEmail(clientDto.getEmail());
        client.setRole(clientDto.getRole());
        ClientDetails clientDetails = convertClientDetailsDtoToEntity(clientDto.getClientDetailsDto());
        client.setClientDetails(clientDetails);

        ClientAddress clientAddress = convertClientAddressDtoToEntity(clientDto.getClientAddressDto());
        client.setClientAddress(clientAddress);

        return client;
    }

    private ClientDetails convertClientDetailsDtoToEntity(ClientDetailsDto clientDetailsDto) {
        if (clientDetailsDto == null) {
            throw new IllegalArgumentException("ClientDetailsDto cannot be null");
        }

        ClientDetails clientDetails = new ClientDetails();
        clientDetails.setId(clientDetailsDto.getId());
        clientDetails.setSurname(clientDetailsDto.getSurname());
        clientDetails.setName(clientDetailsDto.getName());
        clientDetails.setBirthDate(clientDetailsDto.getBirthDate());
        clientDetails.setPassportNumber(clientDetailsDto.getPassportNumber());
        clientDetails.setIdentityNumber(clientDetailsDto.getIdentityNumber());
        clientDetails.setDateIssue(clientDetailsDto.getDateIssue());
        clientDetails.setDateExpiry(clientDetailsDto.getDateExpiry());

        return clientDetails;
    }

    private ClientAddress convertClientAddressDtoToEntity(ClientAddressDto clientAddressDto) {
        if (clientAddressDto == null) {
            throw new IllegalArgumentException("ClientAddressDto cannot be null");
        }

        ClientAddress clientAddress = new ClientAddress();
        clientAddress.setId(clientAddressDto.getId());
        clientAddress.setCountry(clientAddressDto.getCountry());
        clientAddress.setCity(clientAddressDto.getCity());
        clientAddress.setStreet(clientAddressDto.getStreet());
        clientAddress.setHouseNumber(clientAddressDto.getHouseNumber());
        clientAddress.setFlatNumber(clientAddressDto.getFlatNumber());
        clientAddress.setPhoneNumber(clientAddressDto.getPhoneNumber());

        return clientAddress;
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
        @Transactional(readOnly = true)
    public ClientDto getClientById(String id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Client WHERE id = :id";
        Query<Client> query = session.createQuery(hql, Client.class);
        query.setParameter("id", id);
            Client client = query.uniqueResult();

            if (client != null) {
                return convertToDto(client);
            }

            return null;

    }

//    @Override
//    public Optional<ClientDto> getClientById(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        String hql = "FROM Client WHERE id = :id";
//        Query<Client> query = session.createQuery(hql, Client.class);
//        query.setParameter("id", id);
//        Client client = query.uniqueResult();
//
//        return Optional.ofNullable(client).map(this::convertToDto);
//    }



    @Override
    @Transactional(readOnly = true)
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





}
