package by.nata.data.dao;

import by.nata.data.entity.ClientAddress;
import by.nata.data.model.ClientDetailsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientAddressDao extends BaseDao<String, ClientAddress> {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public ClientAddressDao(SessionFactory sessionFactory ){
        super(sessionFactory, ClientAddress.class);

    }
//    public ClientDetailsDto save(ClientDetailsDto clientDetailstDto) {
//        session = sessionFactory.getCurrentSession();
//        session.save(clientDetailstDto);
//        return clientDetailstDto;
//    }
}
