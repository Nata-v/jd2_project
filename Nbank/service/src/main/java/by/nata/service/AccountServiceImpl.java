package by.nata.service;

import by.nata.data.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{


    @Override
    public Account create(Account account) {
        return null;
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
    public Account updateAccount(String id, Account account) {
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
