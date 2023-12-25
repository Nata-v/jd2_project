package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GenericGenerator(strategy = "uuid", name = "account_uuid")
    @GeneratedValue(generator = "account_uuid")
    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private String accountNumber;
    @Column(name = "DATE_OPEN")
    //@DateTimeFormat
    //@Temporal(TemporalType.TIME)
    private ZonedDateTime dateOpen;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    public Account() {
    }

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
}
