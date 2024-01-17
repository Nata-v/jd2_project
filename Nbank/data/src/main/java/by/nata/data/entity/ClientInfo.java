package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;


@Entity
@Table(name = "CLIENT_INFO")
public class ClientInfo {
    @Id
    @GenericGenerator(strategy = "uuid", name = "client_info_uuid")
    @GeneratedValue(generator = "client_info_uuid")
    @Column(name = "ID")
    private String id;

    @JoinColumn(name = "CLIENT_ID")
    private Client clientId;
    @Column(name = "DATE")
    private ZonedDateTime date;
    @JoinColumn(name = "BANKOMAT_OPERATION_ID")
    private BankomatOperations bankomatOperation;

    @JoinColumn(name = "PRODUCTS_OPERATION_ID")
    private ProductsOperation productsOperation;
    @JoinColumn(name = "TRANSACTIONS_ID")
    private Transactions transaction;

}
