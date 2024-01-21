package by.nata.service;

import by.nata.data.dao.AccountDao;
import by.nata.data.dao.TransactionsDao;
import by.nata.data.entity.TypeOperation;
import by.nata.data.model.AccountDto;
import by.nata.data.model.TransactionsDto;
import by.nata.service.model.Account;
import by.nata.service.model.Transactions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service

public class TransactionsServiceImpl implements TransactionsService{
private final TransactionsDao transactionsDao;

    public TransactionsServiceImpl(TransactionsDao transactionsDao) {
        this.transactionsDao = transactionsDao;
    }

    @Override
    public void saveTransactionsReplenishment(Transactions transactions) {
        ZonedDateTime date = ZonedDateTime.now();
        String accountNumber = transactions.getAccountNumber();
        BigDecimal newBalance = transactions.getBalance();
        TransactionsDto transactionsDto = new TransactionsDto(
                transactions.getId(),
                accountNumber,
                transactions.getAccountNumberRecipient(),
                newBalance,
                transactions.getTransaction_currency(),
                date,
                TypeOperation.ADD_BALANCE
        );
        transactionsDao.save(transactionsDto);

    }

    @Override
    public void saveTransactionsWithdrawal(Transactions transactions) {
        ZonedDateTime date = ZonedDateTime.now();
        String accountNumber = transactions.getAccountNumber();
        BigDecimal newBalance = transactions.getBalance();
        TransactionsDto transactionsDto = new TransactionsDto(
                transactions.getId(),
                accountNumber,
                transactions.getAccountNumberRecipient(),
                newBalance,
                transactions.getTransaction_currency(),
                date,
                TypeOperation.WITHDRAW
        );
        transactionsDao.save(transactionsDto);

    }

    @Override
    public void saveTransactionsTransfer(Transactions transactions) {
        ZonedDateTime date = ZonedDateTime.now();
        String accountNumber_sender = transactions.getAccountNumber();
        String accountNumber_recipient = transactions.getAccountNumberRecipient();
        BigDecimal newBalance = transactions.getBalance();
        TransactionsDto transactionsDto = new TransactionsDto(
                transactions.getId(),
                accountNumber_sender,
                accountNumber_recipient,
                newBalance,
                transactions.getTransaction_currency(),
                date,
                TypeOperation.TRANSFER
        );
        transactionsDao.save(transactionsDto);

    }

    @Override
    public List<Transactions> findAllTransactions() {
        List<TransactionsDto> transactionsDto = transactionsDao.findAllTransactions();

        List<Transactions> transactions = transactionsDto.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());

        return transactions;
    }

    private Transactions convertToModel(TransactionsDto transactionsDto){
        return new Transactions(
                transactionsDto.getId(),
                transactionsDto.getAccountNumber(),
                transactionsDto.getAccountNumberRecipient(),
                transactionsDto.getBalance(),
                transactionsDto.getTransaction_currency(),
                transactionsDto.getDate(),
                transactionsDto.getType_operation()

        );
    }
}
