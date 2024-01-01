package by.nata.data.dao;

import by.nata.data.entity.ClientDetails;

import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface ClientDetailsDao  {

    void save(ClientDetailsDto clientDetailsDto);
     Optional<ClientDetailsDto> findById(String id);

//    private SessionFactory sessionFactory;
//    private Session session;
//@Autowired
//    public ClientDetailsDao(SessionFactory sessionFactory ){
//        super(sessionFactory, ClientDetails.class);
//
//    }
//
//    public ClientDetailsDto save(ClientDetailsDto clientDetailstDto) {
//        session = sessionFactory.getCurrentSession();
//        session.save(clientDetailstDto);
//        return clientDetailstDto;
//    }
}
