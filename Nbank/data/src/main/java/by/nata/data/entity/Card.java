package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


import java.time.ZonedDateTime;
import java.util.Objects;


@Entity
@Table(name = "CARD")
//@Audited
public class Card {
    @Id
    @GenericGenerator(strategy = "uuid", name = "card_uuid")
    @GeneratedValue(generator = "card_uuid")
    @Column(name = "CARD_ID")
    private String cardId;

    @JoinColumn(name = "ACCOUNT_ID")
    @ManyToOne(cascade = CascadeType.ALL)
   // @NotAudited
    private Account accountId;
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Column(name = "EXPIRY_DATE")
    private ZonedDateTime expiryDate;

    @Column(name = "CVV")
    private String cvv;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CARD_STATUS")
    //@NotAudited
    private CardStatus cardStatus;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CURRENCY")
   // @NotAudited
    private Currency currency;

    public Card() {
    }

    public Card(String cardId, Account accountId, String cardNumber, ZonedDateTime expiryDate, String cvv, CardStatus cardStatus, Currency currency) {
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

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ZonedDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Card card)) return false;
        return Objects.equals(cardId, card.cardId) && Objects.equals(accountId, card.accountId) && Objects.equals(cardNumber, card.cardNumber) && Objects.equals(expiryDate, card.expiryDate) && Objects.equals(cvv, card.cvv) && cardStatus == card.cardStatus && currency == card.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, accountId, cardNumber, expiryDate, cvv, cardStatus, currency);
    }
}
