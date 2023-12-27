package by.nata.data.dao;

import by.nata.data.entity.ClientDetails;

import by.nata.data.model.ClientDetailsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientDetailsDao extends BaseDao<String, ClientDetails>{

    private SessionFactory sessionFactory;
    private Session session;

    public ClientDetailsDao(SessionFactory sessionFactory ){
        super(sessionFactory, ClientDetails.class);

    }

    public ClientDetailsDto save(ClientDetailsDto clientDetailstDto) {
        session = sessionFactory.getCurrentSession();
        session.save(clientDetailstDto);
        return clientDetailstDto;
    }
}
