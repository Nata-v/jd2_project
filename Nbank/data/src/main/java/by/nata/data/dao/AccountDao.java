package by.nata.data.dao;



import by.nata.data.entity.Account;
import by.nata.data.entity.Client;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class AccountDao extends BaseDao<String, Account>{
    public AccountDao(SessionFactory sessionFactory) {
        super(sessionFactory, Account.class);
    }

}
