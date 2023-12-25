package by.nata.data.model;

import by.nata.data.entity.Account;
import by.nata.data.entity.CardStatus;
import by.nata.data.entity.Currency;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;
@Getter
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
}
