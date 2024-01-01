package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
@Table(name = "BANKOMAT_OPERATIONS")
public class BankomatOperations {
    @Id
    @GenericGenerator(strategy = "uuid", name = "bankomat_operations_uuid")
    @GeneratedValue(generator = "bankomat_operations_uuid")
    @Column(name = "ID")
    private String id;

    @JoinColumn(name = "CARD_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;
    @Column(name = "DATE")
    private ZonedDateTime date;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
@Enumerated(EnumType.STRING)
    @JoinColumn(name = "TYPE_OPERATION")
    private TypeOperation typeOperation;



}
