package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.ClientAddressDao;
import by.nata.data.dao.ClientDao;
import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.entity.Account;
import by.nata.data.entity.Currency;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{


    private final AccountDao accountDao;
    private final ClientDao clientDao;
    private final ClientService clientService;
    private final ClientDetailsDao clientDetailsDao;
    private final ClientAddressDao clientAddressDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, ClientDao clientDao, ClientService clientService, ClientDetailsDao clientDetailsDao, ClientAddressDao clientAddressDao) {
        this.accountDao = accountDao;
        this.clientDao = clientDao;
        this.clientService = clientService;
        this.clientDetailsDao = clientDetailsDao;
        this.clientAddressDao = clientAddressDao;
    }



    @Override
    public void createAccount(AccountDto accountDto, String id) {
        String accountNumber = generateAccountNumber();
        String pin = generateRandomPin();
        ZonedDateTime openDate = ZonedDateTime.now();
        ZonedDateTime lastVisit = ZonedDateTime.now();


        Account account = new Account();
        account.setClient(clientDao.getClientById(id));
        account.setAccountNumber(accountNumber);
        account.setDateOpen(openDate);
        account.setDateLastVisit(lastVisit);
      //  account.setBalance(BigDecimal.valueOf(0.0));
        account.setBalance(accountDto.getBalance());
account.setCurrency(Currency.EUR);
        account.setPin(pin);
        accountDao.save(account);
    }






    private String generateAccountNumber(){
        String accountNumber;
        do{
            accountNumber = UUID.randomUUID().toString().replaceAll("-", "")
                    .substring(0, 6);
        }while (accountDao.findByAccountNumber(accountNumber) != null);
        return accountNumber;
    }

    public static String generateRandomPin() {
        Random random = new Random();
        int pinNumber = random.nextInt(10000);

        return String.format("%04d", pinNumber);
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
                accountDto.getDateLastVisit(),
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
    public void cashDeposit(String accountNumber, String pin, BigDecimal balance) {
       // account.setBalance(BigDecimal.valueOf(0.0));
        //                account.setDateOpen(ZonedDateTime.now()),
//                account.setBalance(BigDecimal.ZERO),
//                account.setCurrency(Currency.valueOf(account.getCurrency().name())),
//        account.setPin(pin));
    }

    @Override
    public void cashWithdrawal(String accountNumber, String pin, BigDecimal balance) {

    }



    @Override
    public List<Account> getAllAccounts() {

        return null;
    }



    @Override
    public Account findAccountById(String id) {
        return null;
    }

    @Override
    public List<Account> getAccountByClientId(String clientId) {
        return null;
    }

    @Override
    public Optional<by.nata.service.model.Account> updateAccount(String id, by.nata.service.model.Account account,
                                                                 ClientDetails clientDetails) {

//        return accountDao.findAccountById(id)
//                .map(accountDto -> new AccountDto(
//                        account.setAccountId(account.getAccountId()),
//                        account.setClientDetails(account.getClientDetails()),
//                        account.setAccountNumber(account.getAccountNumber()),
//                        account.setDateOpen(account.getDateOpen()),
//                        account.setDateLastVisit(ZonedDateTime.now()),
//                        account.setBalance(account.getBalance()),
//                        Currency.EUR,
//                        account.setCurrency(Currency.EUR),
//                        account.setPin(account.getPin())
//                        );
        return null;
    }

    @Transactional
    public void updateAccount(String accountId, BigDecimal newBalance) {
        ZonedDateTime lastVisit = ZonedDateTime.now();
//        Account existingAccount = accountDao.getAccountById(accountId);
//
//        if (existingAccount != null) {
//            existingAccount.setBalance(newBalance);
//            existingAccount.setDateLastVisit(lastVisit);
//
//            accountDao.updateAccount(existingAccount);
//        }
    }
    @Override
    public Account addBalance(String id, BigDecimal amount, String clientId) {
        return null;
    }

    @Override
    public Account withdrawBalance(String id, BigDecimal amount, String clientId) {
        return null;
    }



}
