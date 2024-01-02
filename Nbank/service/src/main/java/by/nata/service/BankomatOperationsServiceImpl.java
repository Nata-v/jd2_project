package by.nata.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class BankomatOperationsServiceImpl implements BankomatOperationsService{


    @Override
    public void addBalance(String id, BigDecimal amount, String cardId) {

    }

    @Override
    public void withdrawBalance(String id, BigDecimal amount, String cardId) {

    }

    @Override
    public void checkBalance(String id, BigDecimal amount, String cardId) {

    }
}
