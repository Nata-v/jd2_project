package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


import java.math.BigDecimal;
import java.time.ZonedDateTime;


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
    private String account_number;
    @Column(name = "ACCOUNT_NUMBER_RECIPIENT")
    private String account_number_recipient;
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "UPDATED_AMOUNT")
    private BigDecimal updated_amount;
    @Column(name = "DATE")
    private ZonedDateTime date;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "TYPE_OPERATION")
    private TypeOperation type_operation;

    public Transactions() {
    }

    public Transactions(String id, String account_number, String account_number_recipient, BigDecimal amount, BigDecimal updated_amount, ZonedDateTime date, TypeOperation type_operation) {
        this.id = id;
        this.account_number = account_number;
        this.account_number_recipient = account_number_recipient;
        this.amount = amount;
        this.updated_amount = updated_amount;
        this.date = date;
        this.type_operation = type_operation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_number_recipient() {
        return account_number_recipient;
    }

    public void setAccount_number_recipient(String account_number_recipient) {
        this.account_number_recipient = account_number_recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getUpdated_amount() {
        return updated_amount;
    }

    public void setUpdated_amount(BigDecimal updated_amount) {
        this.updated_amount = updated_amount;
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
}
