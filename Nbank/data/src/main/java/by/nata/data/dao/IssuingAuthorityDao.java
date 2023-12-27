package by.nata.data.dao;

import by.nata.data.entity.Cities;
import by.nata.data.entity.IssuingAuthority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IssuingAuthorityDao extends BaseDao<String, IssuingAuthority> {
@Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public IssuingAuthorityDao(SessionFactory sessionFactory ){
        super(sessionFactory, IssuingAuthority.class);

    }
}
