package by.nata.data.model;

import by.nata.data.entity.Card;
import by.nata.data.entity.TypeOperation;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public final class BancomatOperationsDto implements Serializable {
    private static final long serialVersionUID = -4004789084607827376L;

    private final String id;

    private final Card card;

    private final ZonedDateTime date;
    private final BigDecimal amount;
    private final TypeOperation typeOperation;

    public BancomatOperationsDto(String id, Card card, ZonedDateTime date, BigDecimal amount, TypeOperation typeOperation) {
        this.id = id;
        this.card = card;
        this.date = date;
        this.amount = amount;
        this.typeOperation = typeOperation;
    }

    public String getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }
}
