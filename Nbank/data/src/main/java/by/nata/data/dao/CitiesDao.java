package by.nata.data.dao;

import by.nata.data.entity.Cities;
import by.nata.data.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CitiesDao extends BaseDao<String, Cities> {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public CitiesDao(SessionFactory sessionFactory ){
        super(sessionFactory, Cities.class);

    }

}
