package by.nata.service;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    List<by.nata.service.model.Account> getAllAccounts();

    by.nata.service.model.Account findByAccountNumber(String accountNumber);

    void deleteAccountByAccountNumber(String accountNumber);

    void createAccount(by.nata.service.model.Account account, String id);

    void cashDeposit(String accountNumber, String pin, BigDecimal balance);

    void cashWithdrawal(String accountNumber, String pin, BigDecimal balance);

    void cashTransfer(String accountNumber, String accountNumberRecipient, String pin, BigDecimal balance);

}
