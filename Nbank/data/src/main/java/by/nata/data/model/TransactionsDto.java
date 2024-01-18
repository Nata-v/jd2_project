package by.nata.data.model;

import by.nata.data.entity.Card;
import by.nata.data.entity.TypeOperation;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


public final class TransactionsDto implements Serializable {
    private static final long serialVersionUID = -4308506027488773218L;

    private final String id;
    private final String account_number;
    private final String account_number_recipient;

    private final BigDecimal amount;
    private final BigDecimal updated_amount;

    private final ZonedDateTime date;

    private final TypeOperation type_operation;

    public TransactionsDto(String id, String account_number, String account_number_recipient, BigDecimal amount, BigDecimal updated_amount, ZonedDateTime date, TypeOperation type_operation) {
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

    public String getAccount_number() {
        return account_number;
    }

    public String getAccount_number_recipient() {
        return account_number_recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getUpdated_amount() {
        return updated_amount;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public TypeOperation getType_operation() {
        return type_operation;
    }
}
