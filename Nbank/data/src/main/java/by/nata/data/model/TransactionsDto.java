package by.nata.data.model;

import by.nata.data.entity.Card;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


public final class TransactionsDto implements Serializable {
    private static final long serialVersionUID = -4308506027488773218L;

    private final String id;
    private final Card cardIdSender;
    private final Card cardIdRecipient;
    private final BigDecimal amount;

    private final ZonedDateTime date;

    public TransactionsDto(String id, Card cardIdSender, Card cardIdRecipient, BigDecimal amount, ZonedDateTime date) {
        this.id = id;
        this.cardIdSender = cardIdSender;
        this.cardIdRecipient = cardIdRecipient;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public Card getCardIdSender() {
        return cardIdSender;
    }

    public Card getCardIdRecipient() {
        return cardIdRecipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ZonedDateTime getDate() {
        return date;
    }
}
