package by.nata.data.model;

import by.nata.data.entity.Currency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


public class AccountDto implements Serializable {
    private static final long serialVersionUID = 818061212323220354L;

    private String accountId;


    private ClientDto clientDto;

    private String accountNumber;

    private ZonedDateTime dateOpen;

    private BigDecimal balance;
    private Currency currency;
    private String pin;

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

}
