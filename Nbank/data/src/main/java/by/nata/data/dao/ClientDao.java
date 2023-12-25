package by.nata.data.dao;

import by.nata.data.entity.Client;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class ClientDao extends BaseDao<String, Client>{
    public ClientDao(SessionFactory sessionFactory ){
        super(sessionFactory, Client.class);

    }


}

