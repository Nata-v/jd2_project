package by.nata.service.model;

import by.nata.data.entity.Currency;
import by.nata.data.entity.TypeOperation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Transactions implements Serializable {

    private static final long serialVersionUID = -5436495074173711555L;

    private String id;
    private String accountNumber;
    private String account_number_recipient;

    private BigDecimal balance;
    private Currency transaction_currency;
    private ZonedDateTime date;
    private TypeOperation type_operation;

    public Transactions() {
    }

    public Transactions(String id, String accountNumber, String account_number_recipient, BigDecimal balance, Currency transaction_currency, ZonedDateTime date, TypeOperation type_operation) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.account_number_recipient = account_number_recipient;
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

    public String getAccount_number_recipient() {
        return account_number_recipient;
    }

    public void setAccount_number_recipient(String account_number_recipient) {
        this.account_number_recipient = account_number_recipient;
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

}
