package by.nata.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENT_ADDRESS")
public class ClientAddress {

    @Id
    @GenericGenerator(strategy = "uuid", name = "client_address_uuid")
    @GeneratedValue(generator = "client_address_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "REGION")
    private String region;
    @Column(name = "LOCALITY")
    private String locality;
    @JoinColumn(name = "CITY_ID")
    private Cities city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Column(name = "FLAT_NUMBER")
    private String flatNumber;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;


}
