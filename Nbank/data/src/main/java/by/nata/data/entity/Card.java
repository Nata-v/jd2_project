package by.nata.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


import java.math.BigDecimal;
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
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "EXPIRY_DATE")
    private ZonedDateTime expiryDate;

    @Column(name = "CVV")
    private String cvv;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CARD_STATUS")
    //@NotAudited
    private CardStatus card_status;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CURRENCY")
    // @NotAudited
    private Currency currency;


    public Card() {
    }

    public Card(String cardId, Account accountId, String cardNumber, BigDecimal balance, ZonedDateTime expiryDate, String cvv, CardStatus card_status, Currency currency) {
        this.cardId = cardId;
        this.accountId = accountId;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Card card)) return false;
        return Objects.equals(getCardId(), card.getCardId()) && Objects.equals(getAccountId(), card.getAccountId()) && Objects.equals(getCardNumber(), card.getCardNumber()) && Objects.equals(getBalance(), card.getBalance()) && Objects.equals(getExpiryDate(), card.getExpiryDate()) && Objects.equals(getCvv(), card.getCvv()) && getCard_status() == card.getCard_status() && getCurrency() == card.getCurrency();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId(), getAccountId(), getCardNumber(), getBalance(), getExpiryDate(), getCvv(), getCard_status(), getCurrency());
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", accountId=" + accountId +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                ", expiryDate=" + expiryDate +
                ", cvv='" + cvv + '\'' +
                ", card_status=" + card_status +
                ", currency=" + currency +
                '}';
    }
}
