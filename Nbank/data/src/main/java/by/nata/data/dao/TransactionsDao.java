package by.nata.data.dao;

import java.math.BigDecimal;

public interface TransactionsDao {

    void cashDeposit(String accountNumber, String pin, BigDecimal balance);
    void cashWithdrawal(String accountNumber, String pin, BigDecimal balance);
}
