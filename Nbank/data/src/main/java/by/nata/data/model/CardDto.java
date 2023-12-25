package by.nata.data.model;

import by.nata.data.entity.Account;
import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Currency;


import java.io.Serializable;
import java.time.ZonedDateTime;

public final class CardDto implements Serializable {
    private static final long serialVersionUID = -7396794317512051708L;

    private final String cardId;

    private final Account accountId;

    private final String cardNumber;

    private final ZonedDateTime expiryDate;

    private final String cvv;
    private final CardStatus cardStatus;

    private final Currency currency;

    public CardDto(String cardId, Account accountId, String cardNumber, ZonedDateTime expiryDate, String cvv, CardStatus cardStatus, Currency currency) {
        this.cardId = cardId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardStatus = cardStatus;
        this.currency = currency;
    }

    public String getCardId() {
        return cardId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public ZonedDateTime getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public Currency getCurrency() {
        return currency;
    }
}
