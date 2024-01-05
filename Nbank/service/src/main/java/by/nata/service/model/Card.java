package by.nata.service.model;

import by.nata.data.entity.Account;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Card implements Serializable {
    private static final long serialVersionUID = 413071048981360036L;
    private final String cardId;
    private final Account accountId;
    private final String cardNumber;
    private final ZonedDateTime expiryDate;
    private final String cvv;
//    private final CardStatus cardStatus;
//
//    private final Currency currency;

    public Card(String cardId, Account accountId, String cardNumber, ZonedDateTime expiryDate, String cvv) {
        this.cardId = cardId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
//        this.cardStatus = cardStatus;
//        this.currency = currency;
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

//    public CardStatus getCardStatus() {
//        return cardStatus;
//    }
//
//    public Currency getCurrency() {
//        return currency;
//    }
}
