package by.nata.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;


@Entity
@Table(name = "CLIENT_ADDRESS")
public class ClientAddress {

    @Id
    @GenericGenerator(strategy = "uuid", name = "client_address_uuid")
    @GeneratedValue(generator = "client_address_uuid")
    @Column(name = "ID")
    private String id;
    @NotEmpty(message = "Enter country!")
    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    @NotEmpty(message = "Enter street!")
    @Size(min = 2, max = 30, message = "Enter street!")
    private String street;
    @Min(value = 0)
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Min(value = 0)
    @Column(name = "FLAT_NUMBER")
    private String flatNumber;
    //@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid phone number")
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ClientAddress that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getHouseNumber(), that.getHouseNumber()) && Objects.equals(getFlatNumber(), that.getFlatNumber()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getCity(), getStreet(), getHouseNumber(), getFlatNumber(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
