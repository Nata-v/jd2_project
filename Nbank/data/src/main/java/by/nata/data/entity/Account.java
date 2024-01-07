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

    @JoinColumn(name = "CLIENT_DETAILS_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientDetails clientDetails;
    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private String accountNumber;
    @Column(name = "DATE_OPEN")
    //@DateTimeFormat
    //@Temporal(TemporalType.TIME)
    private ZonedDateTime dateOpen;
    @Column(name = "DATE_LAST_VISIT")
    private ZonedDateTime dateLastVisit;

    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CURRENCY")
    // @NotAudited
    private Currency currency;
    @Column(name = "pin")
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

    public ZonedDateTime getDateLastVisit() {
        return dateLastVisit;
    }

    public void setDateLastVisit(ZonedDateTime dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
    }
}
