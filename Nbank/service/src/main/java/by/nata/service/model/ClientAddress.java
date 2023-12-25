package by.nata.service.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ClientAddress implements Serializable {
    private static final long serialVersionUID = -1357701676527618932L;

    private final String id;

    private final String country;
    private final String region;
    private final String locality;
    private final Cities city;
    private final String street;
    private final String houseNumber;
    private final String flatNumber;
    private final String phoneNumber;

    public ClientAddress(String id, String country, String region, String locality, Cities city, String street, String houseNumber, String flatNumber, String phoneNumber) {
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
}
