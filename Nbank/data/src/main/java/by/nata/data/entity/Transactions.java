package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;


@Entity
@Table(name = "TRANSACTIONS")
//@Audited
public class Transactions {
    @Id
    @GenericGenerator(strategy = "uuid", name = "transactions_uuid")
    @GeneratedValue(generator = "transactions_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "ACCOUNT_NUMBER_RECIPIENT")
    private String accountNumberRecipient;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "TRANSACTION_CURRENCY")
    // @NotAudited
    private Currency transaction_currency;

    @Column(name = "DATE")
    private ZonedDateTime date;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "TYPE_OPERATION")
    private TypeOperation type_operation;

    public Transactions() {
    }

    public Transactions(String id, String accountNumber, String accountNumberRecipient, BigDecimal balance, Currency transaction_currency, ZonedDateTime date, TypeOperation type_operation) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountNumberRecipient= accountNumberRecipient;
        this.balance = balance;
        this.transaction_currency = transaction_currency;
        this.date = date;
        this.type_operation = type_operation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumberRecipient() {
        return accountNumberRecipient;
    }

    public void setAccountNumberRecipient(String accountNumberRecipient) {
        this.accountNumberRecipient = accountNumberRecipient;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public TypeOperation getType_operation() {
        return type_operation;
    }

    public void setType_operation(TypeOperation type_operation) {
        this.type_operation = type_operation;
    }

    public Currency getTransaction_currency() {
        return transaction_currency;
    }

    public void setTransaction_currency(Currency transaction_currency) {
        this.transaction_currency = transaction_currency;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Transactions that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAccountNumber(), that.getAccountNumber()) && Objects.equals(getAccountNumberRecipient(), that.getAccountNumberRecipient()) && Objects.equals(getBalance(), that.getBalance()) && getTransaction_currency() == that.getTransaction_currency() && Objects.equals(getDate(), that.getDate()) && getType_operation() == that.getType_operation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getAccountNumberRecipient(), getBalance(), getTransaction_currency(), getDate(), getType_operation());
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountNumberRecipient='" + accountNumberRecipient + '\'' +
                ", balance=" + balance +
                ", transaction_currency=" + transaction_currency +
                ", date=" + date +
                ", type_operation=" + type_operation +
                '}';
    }
}
