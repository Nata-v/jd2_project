package by.nata.service;

import by.nata.data.entity.Account;
import by.nata.data.model.TransactionsDto;
import by.nata.service.model.Transactions;

import java.math.BigDecimal;

public interface TransactionsService {
    void saveTransactionsReplenishment(Transactions transactions);
    void saveTransactionsWithdrawal(Transactions transactions);
    void saveTransactionsTransfer(Transactions transactions);

}
