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

//    @JoinColumn(name = "CLIENT_ID")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Client client;

    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "REGION")
    private String region;
    @Column(name = "LOCALITY")
    private String locality;
    @JoinColumn(name = "CITY_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Cities city;
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

    public ClientAddress(String id, String country, String region, String locality, Cities city, String street, String houseNumber, String flatNumber, String phoneNumber) {
        this.id = id;
       // this.client = client;
        this.country = country;
        this.region = region;
        this.locality = locality;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
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
