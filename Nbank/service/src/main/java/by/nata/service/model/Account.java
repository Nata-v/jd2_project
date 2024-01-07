package by.nata.service.model;

import by.nata.data.entity.Currency;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

public class Account implements Serializable {
    private static final long serialVersionUID = 745959034670944882L;

    private  String accountId;

    private ClientDetails clientDetails;

    private  String accountNumber;

    //@DateTimeFormat
    //@Temporal(TemporalType.TIME)
    private  ZonedDateTime dateOpen;
    private  ZonedDateTime dateLastVisit;

    private  BigDecimal balance;
    private Currency currency;
    private String pin;

    public Account() {
    }

    public Account(String accountId, ClientDetails clientDetails, String accountNumber, ZonedDateTime dateOpen, ZonedDateTime dateLastVisit, BigDecimal balance, Currency currency, String pin) {
        this.accountId = accountId;
        this.clientDetails = clientDetails;
        this.accountNumber = accountNumber;
        this.dateOpen = dateOpen;
        this.dateLastVisit = dateLastVisit;
        this.balance = balance;
        this.currency = currency;
        this.pin = pin;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public ZonedDateTime getDateLastVisit() {
        return dateLastVisit;
    }

    public void setDateLastVisit(ZonedDateTime dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ZonedDateTime getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(ZonedDateTime dateOpen) {
        this.dateOpen = dateOpen;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

//    public static Account mapFromAccountDto(AccountDto accountDto, ClientDetailsDto clientDetailsDto){
//        return new Account(
//                accountDto.getAccountId(),
//                new ClientDetails(clientDetailsDto.getId(),
//                        clientDetailsDto.getSurname(),
//                        clientDetailsDto.getName(),
//                        clientDetailsDto.getBirthDate(),
//                        clientDetailsDto.getPassportNumber(),
//                        clientDetailsDto.getIdentityNumber(),
//                        clientDetailsDto.getDateIssue(),
//                        clientDetailsDto.getDateExpiry()),
//                accountDto.getAccountNumber(),
//                accountDto.getDateOpen(),
//                accountDto.getBalance(),
//                accountDto.getCurrency(),
//                accountDto.getPin()
//        );
//    }
//    public static AccountDto mapToAccountDto(Account account, ClientDetails clientDetails){
//        return new AccountDto(account.getAccountId(),
//                new ClientDetailsDto(clientDetails.getId(),
//                        clientDetails.getSurname(),
//                        clientDetails.getName(),
//                        clientDetails.getBirthDate(),
//                        clientDetails.getPassportNumber(),
//                        clientDetails.getIdentityNumber(),
//                        clientDetails.getDateIssue(),
//                        clientDetails.getDateExpiry()),
//                account.getAccountNumber(),
//                account.getDateOpen(),
//                account.getBalance(),
//                account.getCurrency(),
//                account.getPin());
//    }
}
