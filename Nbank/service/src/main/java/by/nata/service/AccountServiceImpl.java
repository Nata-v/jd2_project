package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.CardDaoImpl;
import by.nata.data.dao.ClientDao;
import by.nata.data.dao.TransactionsDao;
import by.nata.data.entity.Account;
import by.nata.data.entity.TypeOperation;
import by.nata.data.model.*;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import by.nata.service.model.Transactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

@Service
@Transactional

public class AccountServiceImpl implements AccountService{
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountDao accountDao;
    private final ClientDao clientDao;
    private  final TransactionsDao transactionsDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, ClientDao clientDao, TransactionsDao transactionsDao) {
        this.accountDao = accountDao;
        this.clientDao = clientDao;
        this.transactionsDao = transactionsDao;
    }



    @Override
    public void createAccount(AccountDto accountDto, String id) {
        String accountNumber = generateAccountNumber();
        String pin = generateRandomPin();
        ZonedDateTime openDate = ZonedDateTime.now();
        BigDecimal balance = new BigDecimal("0.0");

        Account account = new Account();
        account.setClient(clientDao.getClientById(id));
        account.setAccountNumber(accountNumber);
        account.setDateOpen(openDate);
        account.setBalance(balance);
        account.setCurrency(accountDto.getCurrency());
        account.setPin(pin);
        accountDao.save(account);
    }

    private String generateAccountNumber(){
        String accountNumber;
        do{
            accountNumber = UUID.randomUUID().toString().replaceAll("-", "")
                    .substring(0, 16);
        }while (accountDao.findByAccountNumber(accountNumber) != null);
        return accountNumber;
    }

    public static String generateRandomPin() {
        Random random = new Random();
        int pinNumber = random.nextInt(10000);

        return String.format("%04d", pinNumber);
    }

    @Override
    public void cashDeposit(String accountNumber, String pin, BigDecimal balance) {
        AccountDto accountDto = accountDao.findByAccountNumber(accountNumber);

        if (accountDto == null || !pin.equals(accountDto.getPin())) {
            throw new IllegalArgumentException("Invalid account number or PIN");
        }

        BigDecimal newBalance = accountDto.getBalance().add(balance);
        accountDto.setBalance(newBalance);
        accountDao.updateAccount(accountDto);

         log.error("Счет с номером " + accountNumber + " не найден");

        }


    @Override
    public void cashWithdrawal(String accountNumber, String pin, BigDecimal balance) {
        AccountDto accountDto = accountDao.findByAccountNumber(accountNumber);

        if (accountDto == null || !pin.equals(accountDto.getPin())) {
            throw new IllegalArgumentException("Invalid account number or PIN");
        }

        BigDecimal newBalance = accountDto.getBalance().subtract(balance);
        accountDto.setBalance(newBalance);
        accountDao.updateAccount(accountDto);

        log.error("Недостаточно средств для снятия!");
    }

    @Override
    public by.nata.service.model.Account findByAccountNumber(String accountNumber) {

        AccountDto accountDto = accountDao.findByAccountNumber(accountNumber);
        if (accountDto != null) {
            return convertToModel(accountDto);
        }
        return null;
    }
    private by.nata.service.model.Account convertToModel(AccountDto accountDto){
        return new by.nata.service.model.Account(
                accountDto.getAccountId(),
               convertToModel(accountDto.getClientDto()),
                accountDto.getAccountNumber(),
                accountDto.getDateOpen(),
                accountDto.getBalance(),
                accountDto.getCurrency(),
                accountDto.getPin()
        );
    }

    private Client convertToModel(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getUsername(),
                clientDto.getPassword(),
                clientDto.getEmail(),
                clientDto.getRole(),
                convertToModelDetails(clientDto.getClientDetailsDto()),
                convertToModelAddress(clientDto.getClientAddressDto()));



    }


    private ClientDetails convertToModelDetails(ClientDetailsDto clientDetailsDto) {
        return new ClientDetails(clientDetailsDto.getId(),
                clientDetailsDto.getSurname(),
                clientDetailsDto.getName(),
                clientDetailsDto.getBirthDate(),
                clientDetailsDto.getPassportNumber(),
                clientDetailsDto.getIdentityNumber(),
                clientDetailsDto.getDateIssue(),
                clientDetailsDto.getDateExpiry());
    }

    private ClientAddress convertToModelAddress(ClientAddressDto clientAddressDto) {
        return new ClientAddress(clientAddressDto.getId(),
                clientAddressDto.getCountry(),
                clientAddressDto.getCity(),
                clientAddressDto.getStreet(),
                clientAddressDto.getHouseNumber(),
                clientAddressDto.getFlatNumber(),
                clientAddressDto.getPhoneNumber());
    }



    @Override
    public List<Account> getAllAccounts() {

        return null;
    }



    @Override
    public Account findAccountById(String id) {
        return null;
    }




}
