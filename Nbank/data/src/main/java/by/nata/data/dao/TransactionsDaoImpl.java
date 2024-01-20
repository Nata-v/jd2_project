package by.nata.data.dao;

import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Transactions;
import by.nata.data.model.TransactionsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
@Transactional
public class TransactionsDaoImpl implements TransactionsDao{
    private static final Logger log = LoggerFactory.getLogger(TransactionsDaoImpl.class);

private final SessionFactory sessionFactory;


    @Autowired
    public TransactionsDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(TransactionsDto transactionsDto) {
        final Session session = sessionFactory.getCurrentSession();
        Transactions transactions = new Transactions(
                transactionsDto.getId(),
                transactionsDto.getAccountNumber(),
                transactionsDto.getAccountNumberRecipient(),
                transactionsDto.getBalance(),
                transactionsDto.getTransaction_currency(),
                transactionsDto.getDate(),
                transactionsDto.getType_operation()
        );

        session.save(transactions);
        log.info("Such accountNumbers doesn't exist!");
    }


}
