package by.nata.service.model;

import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Currency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Card implements Serializable {
    private static final long serialVersionUID = 413071048981360036L;
    private  String cardId;
    private Account account;
    private  String cardNumber;
    private BigDecimal balance;
    private  ZonedDateTime expiryDate;
    private  String cvv;
    private  CardStatus card_status;

    private Currency currency;

    public Card() {
    }

    public Card(String cardId, Account account, String cardNumber, BigDecimal balance, ZonedDateTime expiryDate, String cvv, CardStatus card_status, Currency currency) {
        this.cardId = cardId;
        this.account = account;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.card_status = card_status;
        this.currency = currency;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }


    public String getCardId() {
        return cardId;
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

    public CardStatus getCard_status() {
        return card_status;
    }

    public void setCard_status(CardStatus card_status) {
        this.card_status = card_status;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
