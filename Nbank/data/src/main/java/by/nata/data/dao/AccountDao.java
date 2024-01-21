package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountDao {

     void save(AccountDto accountDto);
    // void save(AccountDto accountDto, String id);
    void updateAccount(AccountDto accountDto);
    List<AccountDto> getAccountById(String accountId);
    List<AccountDto> getAllAccounts();

    AccountDto findByAccountNumber(String accountNumber);
//    Optional<AccountDto> findAccountById(String id);


}
