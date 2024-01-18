package by.nata.service;

import by.nata.data.entity.Account;

import java.math.BigDecimal;

public interface TransactionsService {
    void cashDeposit(String accountNumber, String pin, BigDecimal balance);
    void cashWithdrawal(String accountNumber, String pin, BigDecimal balance);
    // Account addBalance(String id, BigDecimal amount, String clientId);
    Account withdrawBalance(String id, BigDecimal amount, String clientId );
}
