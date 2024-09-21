package by.nata.data.dao;

import by.nata.data.model.TransactionsDto;

import java.util.List;

public interface TransactionsDao {
    String save(TransactionsDto transactionsDto);

    List<TransactionsDto> findAllTransactions();

    List<TransactionsDto> getTransactions(Integer startPosition, Integer pageSize);

    TransactionsDto findById(String id);

}
