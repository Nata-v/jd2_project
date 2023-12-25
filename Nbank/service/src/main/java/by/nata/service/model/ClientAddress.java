package by.nata.service.model;



import java.io.Serializable;


public class ClientAddress implements Serializable {
    private static final long serialVersionUID = -1357701676527618932L;

    private final String id;
    private final Client client;
    private final String country;
    private final String region;
    private final String locality;
    private final Cities city;
    private final String street;
    private final String houseNumber;
    private final String flatNumber;
    private final String phoneNumber;

    public ClientAddress(String id, Client client, String country, String region, String locality, Cities city, String street, String houseNumber, String flatNumber, String phoneNumber) {
        this.id = id;
        this.client = client;
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

    public Cities getCity() {
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

    public Client getClient() {
        return client;
    }
}
