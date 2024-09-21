package by.nata.service.model;

import by.nata.data.entity.Currency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Account implements Serializable {
    private static final long serialVersionUID = 745959034670944882L;

    private String accountId;

    private Client client;

    private String accountNumber;

    private ZonedDateTime dateOpen;

    private BigDecimal balance;
    private Currency currency;
    private String pin;

    public Account() {
    }

    public Account(String accountId, Client client, String accountNumber, ZonedDateTime dateOpen, BigDecimal balance, Currency currency, String pin) {
        this.accountId = accountId;
        this.client = client;
        this.accountNumber = accountNumber;
        this.dateOpen = dateOpen;
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


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

}
