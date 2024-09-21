package by.nata.service;

import by.nata.service.model.Transactions;

import java.util.List;

public interface TransactionsService {
    void saveTransactionsReplenishment(Transactions transactions);

    void saveTransactionsWithdrawal(Transactions transactions);

    void saveTransactionsTransfer(Transactions transactions);

    List<Transactions> findAllTransactions();

}
