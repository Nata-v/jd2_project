package by.nata.data.model;

import by.nata.data.entity.Currency;
import by.nata.data.entity.TypeOperation;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


public final class TransactionsDto implements Serializable {
    private static final long serialVersionUID = -4308506027488773218L;

    private final String id;
    private final String accountNumber;
    private final String account_number_recipient;

    private final BigDecimal balance;
    private final Currency transaction_currency;

    private final ZonedDateTime date;

    private final TypeOperation type_operation;


    public TransactionsDto(String id, String accountNumber, String account_number_recipient, BigDecimal balance, Currency transaction_currency, ZonedDateTime date, TypeOperation type_operation) {
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccount_number_recipient() {
        return account_number_recipient;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public TypeOperation getType_operation() {
        return type_operation;
    }

    public Currency getTransaction_currency() {
        return transaction_currency;
    }
}
