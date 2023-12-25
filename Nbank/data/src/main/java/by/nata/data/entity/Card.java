package by.nata.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARD")
public class Card {
    @Id
    @GenericGenerator(strategy = "uuid", name = "card_uuid")
    @GeneratedValue(generator = "card_uuid")
    @Column(name = "CARD_ID")
    private String cardId;

    @JoinColumn(name = "ACCOUNT_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Account accountId;
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Column(name = "EXPIRY_DATE")
    private ZonedDateTime expiryDate;

    @Column(name = "CVV")
    private String cvv;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CARD_STATUS")
    private CardStatus cardStatus;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "CURRENCY")
    private Currency currency;

}
