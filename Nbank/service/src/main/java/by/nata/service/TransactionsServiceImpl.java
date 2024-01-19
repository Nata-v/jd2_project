package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.TransactionsDao;
import by.nata.data.entity.Account;
import by.nata.data.entity.TypeOperation;
import by.nata.data.model.TransactionsDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Transactional
@Service

public class TransactionsServiceImpl implements TransactionsService{
private final TransactionsDao transactionsDao;
private final AccountDao accountDao;

    public TransactionsServiceImpl(TransactionsDao transactionsDao, AccountDao accountDao) {
        this.transactionsDao = transactionsDao;
        this.accountDao = accountDao;
    }

    @Override
    public void saveTransactionsReplenishment(by.nata.service.model.Transactions transactions) {
        ZonedDateTime date = ZonedDateTime.now();
        String accountNumber = transactions.getAccountNumber();
        BigDecimal newBalance = transactions.getBalance();
        TransactionsDto transactionsDto = new TransactionsDto(
                transactions.getId(),
                accountNumber,
                transactions.getAccount_number_recipient(),
                newBalance,
                transactions.getTransaction_currency(),
                date,
                TypeOperation.ADD_BALANCE
        );
        transactionsDao.save(transactionsDto);

    }

    @Override
    public void saveTransactionsWithdrawal(by.nata.service.model.Transactions transactions) {
        ZonedDateTime date = ZonedDateTime.now();
        String accountNumber = transactions.getAccountNumber();
        BigDecimal newBalance = transactions.getBalance();
        TransactionsDto transactionsDto = new TransactionsDto(
                transactions.getId(),
                accountNumber,
                transactions.getAccount_number_recipient(),
                newBalance,
                transactions.getTransaction_currency(),
                date,
                TypeOperation.WITHDRAW
        );
        transactionsDao.save(transactionsDto);

    }


}
