package by.nata.data.dao;

import by.nata.data.entity.Transactions;
import by.nata.data.model.TransactionsDto;

import java.math.BigDecimal;

public interface TransactionsDao {
void save(TransactionsDto transactionsDto);

}
