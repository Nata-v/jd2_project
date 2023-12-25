package by.nata.service;

import by.nata.data.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    Account create(Account account);
    List<Account> getAllAccounts();
    Account getAccount(String id);
    List<Account> getAccountByClientId(String clientId);
    Account updateAccount(String id, Account account);
    Account addBalance(String id, BigDecimal amount, String clientId);
        Account withdrawBalance(String id, BigDecimal amount, String clientId );
        void delete(String id);
        void deleteAccountByClientId(String clientId);
}
