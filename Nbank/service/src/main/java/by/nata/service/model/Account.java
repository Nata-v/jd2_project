package by.nata.service.model;

import by.nata.data.entity.Client;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Account implements Serializable {
    private static final long serialVersionUID = 745959034670944882L;

    private final String accountId;

    private final Client client;

    private final String accountNumber;

    //@DateTimeFormat
    //@Temporal(TemporalType.TIME)
    private final ZonedDateTime dateOpen;

    private final BigDecimal balance;

    public Account(String accountId, Client client, String accountNumber, ZonedDateTime dateOpen, BigDecimal balance) {
        this.accountId = accountId;
        this.client = client;
        this.accountNumber = accountNumber;
        this.dateOpen = dateOpen;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public Client getClient() {
        return client;
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
}
