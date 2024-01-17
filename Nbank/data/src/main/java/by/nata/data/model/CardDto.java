package by.nata.data.model;

import by.nata.data.entity.CardStatus;


import java.io.Serializable;
import java.time.ZonedDateTime;

public final class CardDto implements Serializable {
    private static final long serialVersionUID = -7396794317512051708L;

    private final String cardId;

    private final AccountDto accountDto;

    private final String cardNumber;

    private final Double amount;

    private final ZonedDateTime expiryDate;

    private final String cvv;
    private final CardStatus card_status;

    private final String currency;

    public CardDto(String cardId,AccountDto accountDto, String cardNumber, Double amount, ZonedDateTime expiryDate, String cvv, CardStatus card_status, String currency) {
        this.cardId = cardId;
        this.accountDto = accountDto;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.card_status = card_status;
        this.currency = currency;
    }

    public String getCardId() {
        return cardId;
    }

    public AccountDto getAccountDto() {
        return accountDto;
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

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }
}
