package by.nata.data.model;

import by.nata.data.entity.Account;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Currency;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;


public  class AccountDto implements Serializable {
    private static final long serialVersionUID = 818061212323220354L;

    private  String accountId;


    private  ClientDto clientDto;

    private  String accountNumber;

    private  ZonedDateTime dateOpen;

    private  BigDecimal balance;
    private Currency currency;
    private  String pin;

    public AccountDto() {
    }

    public AccountDto(String accountId, ClientDto clientDto, String accountNumber, ZonedDateTime dateOpen, BigDecimal balance, Currency currency, String pin) {
        this.accountId = accountId;
        this.clientDto = clientDto;
        this.accountNumber = accountNumber;
        this.dateOpen = dateOpen;
        this.balance = balance;
        this.currency = currency;
        this.pin = pin;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setDateOpen(ZonedDateTime dateOpen) {
        this.dateOpen = dateOpen;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }




    public String getAccountNumber() {
        return accountNumber;
    }

    public ZonedDateTime getDateOpen() {
        return dateOpen;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }
//        public static Account mapToEntity(AccountDto accountDto, ClientDetailsDto clientDetailsDto){
//
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
//    public static AccountDto mapToDtoFromEntity(Account account, ClientDetails clientDetails){
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
//
//    }

}
