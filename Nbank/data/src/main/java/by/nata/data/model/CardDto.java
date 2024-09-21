package by.nata.data.model;

import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Currency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public final class CardDto implements Serializable {
    private static final long serialVersionUID = -7396794317512051708L;

    private final String cardId;

    private final AccountDto accountDto;

    private final String cardNumber;

    private final BigDecimal balance;

    private final ZonedDateTime expiryDate;

    private final String cvv;
    private final CardStatus card_status;

    private final Currency currency;

    public CardDto(String cardId, AccountDto accountDto, String cardNumber, BigDecimal balance, ZonedDateTime expiryDate, String cvv, CardStatus card_status, Currency currency) {
        this.cardId = cardId;
        this.accountDto = accountDto;
        this.cardNumber = cardNumber;
        this.balance = balance;
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

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
