package by.nata.data.dao;


import by.nata.data.entity.Account;
import by.nata.data.entity.Client;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Currency;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao{
//    @Autowired
//    private SessionFactory sessionFactory;
//    private Session session;
//    public AccountDao(SessionFactory sessionFactory) {
//        super(sessionFactory, Account.class);
//    }

    private static final Logger log = LoggerFactory.getLogger(ClientDaoImpl.class);
    private final SessionFactory sessionFactory;


    public AccountDaoImpl(@Autowired SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Account createAccount(ClientDetailsDto clientDetailsDto, AccountDto accountDto) {
        final Session session = sessionFactory.getCurrentSession();
        Account account = new Account(
                accountDto.getAccountId() == null ? getMaxProductId() + 1 : accountDto.getAccountId(),
               new ClientDetails(clientDetailsDto.getId(),
                       clientDetailsDto.getSurname(),
                       clientDetailsDto.getName(),
                       clientDetailsDto.getBirthDate(),
                       clientDetailsDto.getPassportNumber(),
                       clientDetailsDto.getIdentityNumber(),
                       clientDetailsDto.getDateIssue(),
                       clientDetailsDto.getDateExpiry()),
              //  new ClientDetails().setId(clientDetailsDto.getId()),
                accountDto.getAccountNumber(),
               accountDto.getDateOpen(),
               accountDto.getDateLastVisit(),
                accountDto.getBalance(),
                Currency.EUR,
                accountDto.getPin());


        session.save(account);
        return account;
    }
    public String getMaxProductId() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select max(id) from Account", String.class)
                .list()
                .get(0);
    }

    @Override
    public Optional<AccountDto> findAccountById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean isPinCreated(String accountNumber) {
        return false;
    }

    @Override
    public void createPin(String accountNumber, String pin) {

    }

    @Override
    public void updatePin(String accountNumber, String OldPin, String newPin) {

    }

    @Override
    public void cashDeposit(String accountNumber, String pin, BigDecimal balance) {

    }

    @Override
    public void cashWithdrawal(String accountNumber, String pin, BigDecimal balance) {

    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return null;

    }
}
