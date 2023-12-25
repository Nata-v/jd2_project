package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "CLIENT_DETAILS")
public class ClientDetails {

    @Id
    @GenericGenerator(strategy = "uuid", name = "client_details_uuid")
    @GeneratedValue(generator = "client_details_uuid")
    @Column(name = "ID")
    private String id;
    @JoinColumn(name = "CLIENT_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Client client;

    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;
    @Column(name = "PASSPORT_NUMBER", nullable = false)
    private String passportNumber;
    @Column(name = "IDENTITY_NUMBER", nullable = false, unique = true)
    private String identityNumber;
    @JoinColumn(name = "CITY_BIRTH_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Cities city;
    @Column(name = "DATE_ISSUE", nullable = false)
    private Date dateIssue;

    @Column(name = "DATE_EXPIRY", nullable = false)
    private Date dateExpiry;
    @Column(name = "NATIONALITY")
    private String nationality;
    @JoinColumn(name = "ISSUING_AUTHORITY")
    @OneToOne(cascade = CascadeType.ALL)
    private IssuingAuthority issuingAuthority;

    public ClientDetails() {
    }

    public ClientDetails(String id, Client client, String surname, String name, String middleName, Date birthDate, String passportNumber, String identityNumber, Cities city, Date dateIssue, Date dateExpiry, String nationality, IssuingAuthority issuingAuthority) {
        this.id = id;
        this.client = client;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.identityNumber = identityNumber;
        this.city = city;
        this.dateIssue = dateIssue;
        this.dateExpiry = dateExpiry;
        this.nationality = nationality;
        this.issuingAuthority = issuingAuthority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Date getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(Date dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public IssuingAuthority getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(IssuingAuthority issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
