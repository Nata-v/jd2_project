package by.nata.service.model;

import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Currency;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Card implements Serializable {
    private static final long serialVersionUID = 413071048981360036L;
    private  String cardId;
    private Account account;
    private  String cardNumber;
    private Double amount;
    private  ZonedDateTime expiryDate;
    private  String cvv;
    private  CardStatus card_status;

    private String currency;

    public Card() {
    }

    public Card(String cardId, Account account, String cardNumber, Double amount, ZonedDateTime expiryDate, String cvv, CardStatus card_status, String currency) {
        this.cardId = cardId;
        this.account = account;
        this.cardNumber = cardNumber;
        this.amount = amount;
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



    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}