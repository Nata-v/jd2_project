package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
@Table(name = "PRODUCTS_OPERATION")
public class ProductsOperation {
    @Id
    @GenericGenerator(strategy = "uuid", name = "products_operation_uuid")
    @GeneratedValue(generator = "products_operation_uuid")
    @Column(name = "ID")
    private String id;
//@Enumerated(EnumType.STRING)
//    @JoinColumn(name = "PRODUCT_TYPE")
//    private ProductType productType;
    @Column(name = "DATE_START_OPERATION")
    private ZonedDateTime dateStartOperation;
    @Column(name = "DATE_END_OPERATION")
    private ZonedDateTime dateEndOperation;

    @JoinColumn(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "INTEREST_RATE")
    private Integer interestRate;
    @JoinColumn(name = "ACCOUNT_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Account accountId;

}
