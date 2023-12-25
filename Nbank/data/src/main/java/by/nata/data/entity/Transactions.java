package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
    @Id
    @GenericGenerator(strategy = "uuid", name = "transactions_uuid")
    @GeneratedValue(generator = "transactions_uuid")
    @Column(name = "ID")
    private String id;

    @JoinColumn(name = "CARD_ID_SENDER")
    private Card cardIdSender;
    @JoinColumn(name = "CARD_ID_RECIPIENT")
    private Card cardIdRecipient;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "DATE")
    private ZonedDateTime date;


}
