package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
@Table(name = "TRANSACTIONS")
//@Audited
public class Transactions {
    @Id
    @GenericGenerator(strategy = "uuid", name = "transactions_uuid")
    @GeneratedValue(generator = "transactions_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "ACCOUNT_SENDER")
    private String accountSender;
    @Column(name = "ACCOUNT_RECIPIENT")
    private String accountRecipient;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "DATE")
    private ZonedDateTime date;


}
