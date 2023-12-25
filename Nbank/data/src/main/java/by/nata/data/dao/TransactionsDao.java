package by.nata.data.dao;

import by.nata.data.entity.Client;
import by.nata.data.entity.Transactions;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class TransactionsDao extends BaseDao<String,Transactions>  {
    public TransactionsDao(SessionFactory sessionFactory) {
        super(sessionFactory, Transactions.class);
    }

}
