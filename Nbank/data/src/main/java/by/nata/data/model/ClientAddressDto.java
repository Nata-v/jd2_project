package by.nata.data.model;

import by.nata.data.entity.Cities;
import by.nata.data.entity.Client;


import java.io.Serializable;
import java.util.Objects;

public final class ClientAddressDto implements Serializable {
    private static final long serialVersionUID = 2173707496609496930L;

    private final String id;

    private final String country;
    private final String region;
    private final String locality;
   // private final Cities city;
    private final String city;
    private final String street;
    private final String houseNumber;
    private final String flatNumber;
    private final String phoneNumber;

    public ClientAddressDto(String id, String country, String region, String locality, String city, String street, String houseNumber, String flatNumber, String phoneNumber) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ClientAddressDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getRegion(), that.getRegion()) && Objects.equals(getLocality(), that.getLocality()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getHouseNumber(), that.getHouseNumber()) && Objects.equals(getFlatNumber(), that.getFlatNumber()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getRegion(), getLocality(), getCity(), getStreet(), getHouseNumber(), getFlatNumber(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "ClientAddressDto{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
