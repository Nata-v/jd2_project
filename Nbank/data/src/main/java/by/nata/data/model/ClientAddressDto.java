package by.nata.data.model;


import java.io.Serializable;

public final class ClientAddressDto implements Serializable {
    private static final long serialVersionUID = 2173707496609496930L;

    private final String id;

    private final String country;

    private final String city;
    private final String street;
    private final String houseNumber;
    private final String flatNumber;
    private final String phoneNumber;

    public ClientAddressDto(String id, String country, String city, String street, String houseNumber, String flatNumber, String phoneNumber) {
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

    public String getCountry() {
        return country;
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


}
