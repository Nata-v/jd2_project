package by.nata.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "EXPIRY_DATE")
    private ZonedDateTime expiryDate;

    @Column(name = "CVV")
    private String cvv;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CARD_STATUS")
    //@NotAudited
    private CardStatus card_status;
//    @Enumerated(EnumType.STRING)
//    @JoinColumn(name = "CURRENCY")
//    // @NotAudited
//    private Currency currency;
@Column(name = "CURRENCY")
private String currency;

    public Card() {
    }

    public Card(String cardId, String cardNumber, Double amount, ZonedDateTime expiryDate, String cvv, CardStatus card_status, String currency) {
        this.cardId = cardId;
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

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
   // @JsonIgnore

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}