package by.nata.service;

import by.nata.data.entity.Account;
import by.nata.data.model.AccountDto;
import by.nata.service.model.ClientDetails;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<by.nata.service.model.Account> getAllAccounts();
    Account findAccountById(String id);
by.nata.service.model.Account findByAccountNumber(String accountNumber);
void deleteAccount(String accountId);

        void createAccount(by.nata.service.model.Account account, String id);
    void cashDeposit(String accountNumber, String pin, BigDecimal balance);
    void cashWithdrawal(String accountNumber, String pin, BigDecimal balance);
    void cashTransfer(String accountNumber, String accountNumberRecipient, String pin, BigDecimal balance);

}
