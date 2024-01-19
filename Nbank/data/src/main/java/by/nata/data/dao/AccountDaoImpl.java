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


    public void updateAccount(AccountDto accountDto) {
        if (accountDto == null) {
            throw new IllegalArgumentException("AccountDto cannot be null");
        }
        Account account = convertDtoToEntity(accountDto);
        Session session = sessionFactory.getCurrentSession();
        session.merge(account);
    }

    private Account convertDtoToEntity(AccountDto accountDto) {
        if (accountDto == null) {
            throw new IllegalArgumentException("AccountDto cannot be null");
        }

        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());

        Client client = convertClientDtoToEntity(accountDto.getClientDto());
       account.setClient(client);

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setDateOpen(accountDto.getDateOpen());
        account.setBalance(accountDto.getBalance());
        account.setCurrency(accountDto.getCurrency());
        account.setPin(accountDto.getPin());

        return account;
    }

    private Client convertClientDtoToEntity(ClientDto clientDto) {
        if (clientDto == null) {
            throw new IllegalArgumentException("ClientDto cannot be null");
        }
            Client client = new Client();
            client.setId(clientDto.getId());
            client.setUsername(clientDto.getUsername());
            client.setPassword(clientDto.getPassword());
            client.setEmail(clientDto.getEmail());
            client.setRole(clientDto.getRole());
            ClientDetails clientDetails = convertClientDetailsDtoToEntity(clientDto.getClientDetailsDto());
            client.setClientDetails(clientDetails);

            ClientAddress clientAddress = convertClientAddressDtoToEntity(clientDto.getClientAddressDto());
            client.setClientAddress(clientAddress);

        return client;
    }
    private ClientDetails convertClientDetailsDtoToEntity(ClientDetailsDto clientDetailsDto) {
        if (clientDetailsDto == null) {
            throw new IllegalArgumentException("ClientDetailsDto cannot be null");
        }

        ClientDetails clientDetails = new ClientDetails();
        clientDetails.setId(clientDetailsDto.getId());
       clientDetails.setSurname(clientDetailsDto.getSurname());
              clientDetails.setName(clientDetailsDto.getName());
              clientDetails.setBirthDate(clientDetailsDto.getBirthDate());
            clientDetails.setPassportNumber(clientDetailsDto.getPassportNumber());
               clientDetails.setIdentityNumber( clientDetailsDto.getIdentityNumber());
            clientDetails.setDateIssue(clientDetailsDto.getDateIssue());
                clientDetails.setDateExpiry( clientDetailsDto.getDateExpiry());

        return clientDetails;
    }
    private ClientAddress convertClientAddressDtoToEntity(ClientAddressDto clientAddressDto) {
        if (clientAddressDto == null) {
            throw new IllegalArgumentException("ClientAddressDto cannot be null");
        }

        ClientAddress clientAddress = new ClientAddress();
        clientAddress.setId(clientAddressDto.getId());
        clientAddress.setCountry(clientAddressDto.getCountry());
                clientAddress.setCity(clientAddressDto.getCity());
                clientAddress.setStreet(clientAddressDto.getStreet());
                clientAddress.setHouseNumber(clientAddressDto.getHouseNumber());
                clientAddress.setFlatNumber(clientAddressDto.getFlatNumber());
                clientAddress.setPhoneNumber(clientAddressDto.getPhoneNumber());

        return clientAddress;
    }

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