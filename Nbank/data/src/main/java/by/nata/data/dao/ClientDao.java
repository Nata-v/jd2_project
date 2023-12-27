package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.model.ClientDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class ClientDao extends BaseDao<String, Client>{
    private SessionFactory sessionFactory;
    private Session session;

    public ClientDao(SessionFactory sessionFactory ){
        super(sessionFactory, Client.class);

    }
    public ClientDto save(ClientDto clientDto) {
        session = sessionFactory.getCurrentSession();
        session.save(clientDto);
        return clientDto;
    }

}

