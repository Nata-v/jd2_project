package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.entity.Account;
import by.nata.data.entity.Currency;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{


    private final AccountDao accountDao;
    private final ClientDetailsDao clientDetailsDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, ClientDetailsDao clientDetailsDao) {
        this.accountDao = accountDao;
        this.clientDetailsDao = clientDetailsDao;
    }

    //    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Account createAccount( by.nata.service.model.Account account, String id) {
        String accountNumber = generateAccountNumber();
        String pin = generateRandomPin();

        Optional<ClientDetailsDto> clientDetailsDto = clientDetailsDao.findById(id);

        AccountDto accountDto = new AccountDto(
                account.getAccountId(),
                clientDetailsDto.get(),
               accountNumber,
                account.getDateOpen(),
                account.getDateLastVisit(),
                account.getBalance(),
                Currency.EUR,
                pin);

     return accountDao.createAccount(accountDto.getClientDetailsDto(), accountDto);
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

        // Форматирование PIN-кода, чтобы он всегда содержал 4 цифры
        return String.format("%04d", pinNumber);
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
    public Account getAccount(String id) {
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

    @Override
    public Account addBalance(String id, BigDecimal amount, String clientId) {
        return null;
    }

    @Override
    public Account withdrawBalance(String id, BigDecimal amount, String clientId) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAccountByClientId(String clientId) {

    }

}
