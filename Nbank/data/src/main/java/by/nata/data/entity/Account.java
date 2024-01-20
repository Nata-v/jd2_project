package by.nata.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;


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

    @Column(name = "ACCOUNT_NUMBER", nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "DATE_OPEN")
    private ZonedDateTime dateOpen;

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

    public Account(String accountId, String accountNumber, ZonedDateTime dateOpen, BigDecimal balance, Currency currency, String pin) {
        this.accountId = accountId;
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
    @JsonIgnore

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Account account)) return false;
        return Objects.equals(getAccountId(), account.getAccountId()) && Objects.equals(getClient(), account.getClient()) && Objects.equals(getAccountNumber(), account.getAccountNumber()) && Objects.equals(getDateOpen(), account.getDateOpen()) && Objects.equals(getBalance(), account.getBalance()) && getCurrency() == account.getCurrency() && Objects.equals(getPin(), account.getPin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getClient(), getAccountNumber(), getDateOpen(), getBalance(), getCurrency(), getPin());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", dateOpen=" + dateOpen +
                ", balance=" + balance +
                ", currency=" + currency +
                ", pin='" + pin + '\'' +
                '}';
    }
}
