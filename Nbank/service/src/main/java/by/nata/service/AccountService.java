package by.nata.service;

import by.nata.data.entity.Account;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.model.ClientDetails;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {


    List<Account> getAllAccounts();
    Account getAccount(String id);
    List<Account> getAccountByClientId(String clientId);


    Optional<by.nata.service.model.Account> updateAccount(String id, by.nata.service.model.Account account,
                                                          ClientDetails clientDetails);



    Account addBalance(String id, BigDecimal amount, String clientId);
        Account withdrawBalance(String id, BigDecimal amount, String clientId );
        void delete(String id);
        void deleteAccountByClientId(String clientId);


    Account createAccount(by.nata.service.model.Account account, String id);
    public boolean isPinCreated(String accountNumber);
    void createPin(String accountNumber, String pin);
    void updatePin(String accountNumber, String OldPin, String newPin);
    void cashDeposit(String accountNumber, String pin, BigDecimal balance);
    void cashWithdrawal(String accountNumber, String pin, BigDecimal balance);
}
