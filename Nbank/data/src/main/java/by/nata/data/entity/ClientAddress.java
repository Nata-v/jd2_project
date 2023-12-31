package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;



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

//    @JoinColumn(name = "CITY_ID")
//    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Column(name = "FLAT_NUMBER")
    private String flatNumber;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public ClientAddress() {
    }

    public ClientAddress(String id, String country, String city, String street, String houseNumber, String flatNumber, String phoneNumber) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
