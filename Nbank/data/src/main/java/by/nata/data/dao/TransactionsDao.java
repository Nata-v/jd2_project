package by.nata.data.dao;

import by.nata.data.entity.Transactions;
import by.nata.data.model.AccountDto;
import by.nata.data.model.TransactionsDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsDao {
void save(TransactionsDto transactionsDto);
    List<TransactionsDto> findAllTransactions();

}
