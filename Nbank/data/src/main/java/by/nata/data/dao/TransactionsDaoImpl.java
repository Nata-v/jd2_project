package by.nata.data.dao;

import by.nata.data.entity.Transactions;
import by.nata.data.model.TransactionsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TransactionsDaoImpl implements TransactionsDao {
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
    public String save(TransactionsDto transactionsDto) {
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

        return (String) session.save(transactions);

    }

    @Override
    public TransactionsDto findById(String id) {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "from Transactions WHERE id = :searchedId";
        Query<Transactions> query = session.createQuery(hql, Transactions.class);
        query.setParameter("searchedId", id);
        Transactions transactions = query.uniqueResult();

        if (transactions != null) {
            return convertToDto(transactions);
        }
        return null;
    }

    @Override
    public List<TransactionsDto> findAllTransactions() {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT new by.nata.data.entity.Transactions(c.id, c.accountNumber, c.accountNumberRecipient, c.balance, c.transaction_currency, c.date, c.type_operation) FROM Transactions c";
        Query<Transactions> query = session.createQuery(hql, Transactions.class);
        List<Transactions> allTransactions = query.getResultList();

        List<TransactionsDto> transactionsDtos = new ArrayList<>();

        for (Transactions transactions : allTransactions) {
            transactionsDtos.add(convertToDto(transactions));
        }

        return transactionsDtos;
    }

    private TransactionsDto convertToDto(Transactions transactions) {
        return new TransactionsDto(
                transactions.getId(),
                transactions.getAccountNumber(),
                transactions.getAccountNumberRecipient(),
                transactions.getBalance(),
                transactions.getTransaction_currency(),
                transactions.getDate(),
                transactions.getType_operation());
    }

    @Override
    public List<TransactionsDto> getTransactions(Integer startPosition, Integer pageSize) {
        final Session session = sessionFactory.getCurrentSession();

        List<Transactions> transactionsList = session.createQuery("from Transactions", Transactions.class)
                .setFirstResult(startPosition)
                .setMaxResults(pageSize)
                .list();

        List<TransactionsDto> transactionsDtoList = new ArrayList<>();
        for (Transactions transactions : transactionsList) {
            transactionsDtoList.add(convertToDto(transactions));
        }
        return transactionsDtoList;
    }

}
