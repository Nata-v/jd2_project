package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.model.AccountDto;

import java.util.List;

public interface AccountDao {

    String save(AccountDto accountDto);

    Account updateAccount(AccountDto accountDto);

    List<AccountDto> getAccountById(String accountId);

    List<AccountDto> getAllAccounts();

    AccountDto deleteAccountByAccountNumber(String accountNumber);

    AccountDto findByAccountNumber(String accountNumber);


}
