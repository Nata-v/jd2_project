package by.nata.data.model;

import by.nata.data.entity.Account;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Currency;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;


public final class AccountDto implements Serializable {
    private static final long serialVersionUID = 818061212323220354L;

    private final String accountId;


    private final ClientDetailsDto clientDetailsDto;

    private final String accountNumber;

    private final ZonedDateTime dateOpen;
    private final ZonedDateTime dateLastVisit;

    private final BigDecimal balance;
    private final Currency currency;
    private final String pin;

    public AccountDto(String accountId, ClientDetailsDto clientDetailsDto, String accountNumber, ZonedDateTime dateOpen, ZonedDateTime dateLastVisit, BigDecimal balance, Currency currency, String pin) {
        this.accountId = accountId;
        this.clientDetailsDto = clientDetailsDto;
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

    public ClientDetailsDto getClientDetailsDto() {
        return clientDetailsDto;
    }


    public ZonedDateTime getDateLastVisit() {
        return dateLastVisit;
    }

    public Currency getCurrency() {
        return currency;
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
