package by.nata.data.dao;

import by.nata.data.entity.Account;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountDao {

    Account createAccount(ClientDetailsDto clientDetailsDto, AccountDto accountDto);
    public boolean isPinCreated(String accountNumber);
    void createPin(String accountNumber, String pin);
    void updatePin(String accountNumber, String OldPin, String newPin);
    void cashDeposit(String accountNumber, String pin, BigDecimal balance);
    void cashWithdrawal(String accountNumber, String pin, BigDecimal balance);

    Account findByAccountNumber(String accountNumber);
    Optional<AccountDto> findAccountById(String id);


}
