package by.nata.service;

import by.nata.data.model.TransactionsDto;
import by.nata.service.model.Account;
import by.nata.service.model.Transactions;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsService {
    void saveTransactionsReplenishment(Transactions transactions);
    void saveTransactionsWithdrawal(Transactions transactions);
    void saveTransactionsTransfer(Transactions transactions);

    List<Transactions> findAllTransactions();
    //List<by.nata.data.entity.Transactions> getTransactions(Integer startPosition, Integer pageSize);

}
