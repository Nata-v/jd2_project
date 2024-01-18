package by.nata.data.dao;


import by.nata.data.entity.*;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {
    private static final Logger log = LoggerFactory.getLogger(ClientDaoImpl.class);
    private final SessionFactory sessionFactory;
    private ClientDao clientDao;

    @Autowired
    public AccountDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Account account) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(account);
    }


    public void updateAccount(Account account) {
        final Session session = sessionFactory.getCurrentSession();
      //  Account account = convertDtoToEntity(accountDto);
//        String hql = "FROM Account WHERE client.id = :clientId";
//        Query<Account> query = session.createQuery(hql, Account.class);
//        query.setParameter("clientId", clientId);
//        Account account = query.uniqueResult();
        session.update(account);
    }

//    private Account convertDtoToEntity(AccountDto accountDto) {
//        if (accountDto == null) {
//            throw new IllegalArgumentException("AccountDto cannot be null");
//        }
//
//        Account account = new Account();
//        account.setAccountId(accountDto.getAccountId());
//        // convertClientDtoToEntity(accountDto.getClientDto());
//        account.setClient(clientDao.getClientById(accountDto.getClientDto().getId()));
//        account.setAccountNumber(accountDto.getAccountNumber());
//        account.setDateOpen(accountDto.getDateOpen());
//        account.setBalance(accountDto.getBalance());
//        account.setCurrency(accountDto.getCurrency());
//        account.setPin(accountDto.getPin());
//
//        return account;
//    }

//    private void convertClientDtoToEntity(ClientDto clientDto, Account account) {
//        if (clientDto != null) {
//            // Ваш код для установки клиента в аккаунт (например, получение клиента по ID)
//            Client client = clientDao.getClientById(clientDto.getId()); // Подставьте ваш метод для получения клиента по ID
//            account.setClient(client);
//        }

    @Override
    public List<AccountDto> getAccountById(String clientId) {
        final Session session = sessionFactory.getCurrentSession();
            String hql = "FROM Account WHERE client.id = :clientId";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("clientId", clientId);
        Account account = query.uniqueResult();

        if (account != null) {
            return Collections.singletonList(convertToDto(account));
        }
        return null;
    }


    @Override
    public AccountDto findByAccountNumber(String accountNumber) {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "from Account WHERE accountNumber = :searchedAccountNumber";
        Query<Account> query = session.createQuery(hql, Account.class);
        query.setParameter("searchedAccountNumber", accountNumber);
        Account account = query.uniqueResult();

        if (account != null) {
            return convertToDto(account);
        }
        return null;

    }

    private AccountDto convertToDto(Account account) {
        return new AccountDto(
                account.getAccountId(),
                convertToDto(account.getClient()),
                account.getAccountNumber(),
                account.getDateOpen(),
                account.getBalance(),
                account.getCurrency(),
                account.getPin());
    }

    private ClientDto convertToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(),
                client.getRole(),
                convertToDto(client.getClientDetails()),
                convertToDto(client.getClientAddress())
        );
    }

    private ClientDetailsDto convertToDto(ClientDetails clientDetails) {

        return new ClientDetailsDto(clientDetails.getId(),
                clientDetails.getSurname(),
                clientDetails.getName(),
                clientDetails.getBirthDate(),
                clientDetails.getPassportNumber(),
                clientDetails.getIdentityNumber(),
                clientDetails.getDateIssue(),
                clientDetails.getDateExpiry());
    }
    private ClientAddressDto convertToDto(ClientAddress clientAddress) {
        return new ClientAddressDto(clientAddress.getId(),
                clientAddress.getCountry(),
                clientAddress.getCity(),
                clientAddress.getStreet(),
                clientAddress.getHouseNumber(),
                clientAddress.getFlatNumber(),
                clientAddress.getPhoneNumber());
    }
}