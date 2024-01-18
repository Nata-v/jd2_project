package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.ClientDao;
import by.nata.data.entity.Account;
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

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, ClientDao clientDao) {
        this.accountDao = accountDao;
        this.clientDao = clientDao;
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

//        BigDecimal currentBalance = accountDto.getBalance();
//        BigDecimal newBalance = currentBalance.add(balance);
//
//        List<AccountDto> accountDtos = accountDao.getAccountById(accountDto.getAccountId());
//
//        if (accountDtos != null && !accountDtos.isEmpty()) {
//            AccountDto accountDto1 = accountDtos.get(0);
//            accountDto1.setBalance(newBalance);
//
//            accountDao.updateAccount(accountDto1);
        Account account = (Account) accountDao.getAccountById(accountDto.getAccountId());

        if (account != null) {
            BigDecimal currentBalance = account.getBalance();
            BigDecimal newBalance = currentBalance.add(balance);

            account.setBalance(newBalance);
            accountDao.updateAccount(account);

        } else {
            throw new RuntimeException("Account not found");

        }
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


}
