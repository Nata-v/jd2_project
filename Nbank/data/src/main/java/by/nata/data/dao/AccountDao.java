package by.nata.data.dao;


import by.nata.data.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class AccountDao extends BaseDao<String, Account>{
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    public AccountDao(SessionFactory sessionFactory) {
        super(sessionFactory, Account.class);
    }

}
