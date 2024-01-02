package by.nata.service;

import by.nata.data.entity.Account;

import java.math.BigDecimal;

public interface BankomatOperationsService {

     void addBalance(String id, BigDecimal amount, String cardId);
    void withdrawBalance(String id, BigDecimal amount, String cardId );
    void checkBalance(String id, BigDecimal amount, String cardId);
}
