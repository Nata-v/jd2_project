package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.entity.ClientDetails;
import by.nata.data.model.ClientDetailsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ClientDetailsDaoImpl implements ClientDetailsDao {
    private static final Logger log = LoggerFactory.getLogger(ClientDetailsDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public ClientDetailsDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(ClientDetailsDto clientDetailsDto) {

        final Session session = sessionFactory.getCurrentSession();
        ClientDetails clientDetails = new ClientDetails(
                clientDetailsDto.getId() == null ? getMaxProductId() + 1 : clientDetailsDto.getId(),
                clientDetailsDto.getSurname(),
                clientDetailsDto.getName(),
                clientDetailsDto.getMiddleName(),
                clientDetailsDto.getBirthDate(),
                clientDetailsDto.getPassportNumber(),
                clientDetailsDto.getIdentityNumber(),
                clientDetailsDto.getCityBirth(),
                clientDetailsDto.getDateIssue(),
                clientDetailsDto.getDateExpiry()
        );

        session.save(clientDetails);

    }

    public String getMaxProductId() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select max(id) from Client", String.class)
                .list()
                .get(0);
    }


       @Override
    public void delete(String id) {
           Session session = sessionFactory.getCurrentSession();
           session.delete(session.find(ClientDetails.class, id));
           session.flush();
    }

    @Override
    public void update(ClientDetailsDto clientDetailsDto) {
        final Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(clientDetailsDto);
    }

    @Override
    public Optional<ClientDetailsDto> findById(String id) {
        final Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(ClientDetailsDto.class, id));
    }
//
//    @Override
//    public List<ClientDetailsDto> findAll() {
//        return null;
//    }
}
