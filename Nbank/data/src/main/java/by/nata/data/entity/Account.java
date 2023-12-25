package by.nata.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GenericGenerator(strategy = "uuid", name = "account_uuid")
    @GeneratedValue(generator = "account_uuid")
    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private String accountNumber;
    @Column(name = "DATE_OPEN")
    //@DateTimeFormat
    //@Temporal(TemporalType.TIME)
    private ZonedDateTime dateOpen;

    @Column(name = "BALANCE")
    private BigDecimal balance;




}
