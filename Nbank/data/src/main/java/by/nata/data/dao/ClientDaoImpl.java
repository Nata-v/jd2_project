package by.nata.data.dao;

import by.nata.data.entity.Client;

import by.nata.data.entity.ClientAddress;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Role;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import by.nata.data.model.FilterClientDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Client> findByUserName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Client au where au.username=:username", Client.class)
                .setParameter("username", username)
                .list();
    }

    @Override
    public List<Client> findAllByFilter(FilterClientDto filterClientDto) {
        return null;
    }

    @Override
    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.find(Client.class, id));
        session.flush();
    }

    @Override
    public void update(ClientDto clientDto) {
        final Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(clientDto);
    }

    @Override
    public Optional<ClientDto> findById(String id) {
        final Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(ClientDto.class, id));
    }

    @Override
    public List<ClientDto> findAll() {
        final Session session = sessionFactory.getCurrentSession();
        var criteria = session.getCriteriaBuilder().createQuery(ClientDto.class);
        criteria.from(ClientDto.class);
        return session.createQuery(criteria).getResultList();
    }


    @Override

    public void save(ClientDto clientDto
    ) {
        final Session session = sessionFactory.getCurrentSession();

        Client client = new Client(
                clientDto.getId() == null ? getMaxClientId() + 1 : clientDto.getId(),
                clientDto.getUsername(),
                clientDto.getPassword(),
                clientDto.getEmail(),
                Role.USER,
                clientDto.getClientDetails(),
                clientDto.getClientAddress()
//                new ClientDetails(
//                        clientDetailsDto.getId() == null ? getMaxClientDetailsId() + 1 : clientDetailsDto.getId(),
//                        clientDetailsDto.getSurname(),
//                        clientDetailsDto.getName(),
//                        clientDetailsDto.getBirthDate(),
//                        clientDetailsDto.getPassportNumber(),
//                        clientDetailsDto.getIdentityNumber(),
//                        clientDetailsDto.getDateIssue(),
//                        clientDetailsDto.getDateExpiry()
//                ),
//                new ClientAddress(
//                        clientAddressDto.getId() == null ? getMaxClientAddressId() + 1 : clientAddressDto.getId(),
//                        clientAddressDto.getCountry(),
//                        clientAddressDto.getCity(),
//                        clientAddressDto.getStreet(),
//                        clientAddressDto.getHouseNumber(),
//                        clientAddressDto.getFlatNumber(),
//                        clientAddressDto.getPhoneNumber()
        );

        session.save(client);
//log.info("Client saved: {}", client);
//log.error("");
//log.warn("Client details was change: {}", client);
        //log.debug("Client: {}, session: {}", client, session);

        //        Client client = new Client();
//        client.setId(clientDto.getId() == null ? getMaxProductId() + 1 : clientDto.getId());
//        client.setUsername(clientDto.getUsername());
//        client.setPassword(clientDto.getPassword());
//        client.setEmail(clientDto.getEmail());
//        client.setClientDetails(getClientDetails(clientDto.getClientDetails().getId()));

    }

    public String getMaxClientId() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select max(id) from Client", String.class)
                .list()
                .get(0);
    }
//    public String getMaxClientDetailsId() {
//        return sessionFactory
//                .getCurrentSession()
//                .createQuery("select max(id) from CLIENT_DETAILS", String.class)
//                .list()
//                .get(0);
//    }
//    public String getMaxClientAddressId() {
//        return sessionFactory
//                .getCurrentSession()
//                .createQuery("select max(id) from CLIENT_ADDRESS", String.class)
//                .list()
//                .get(0);
//    }

}
