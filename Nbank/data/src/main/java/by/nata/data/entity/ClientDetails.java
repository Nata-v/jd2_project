package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

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


    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "BIRTH_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;
    @Column(name = "IDENTITY_NUMBER", unique = true)
    private String identityNumber;
    //@JoinColumn(name = "CITY_BIRTH_ID")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Cities city;
    @Column(name = "CITY_BIRTH")
    private String cityBirth;

    @Column(name = "DATE_ISSUE")
    private LocalDate dateIssue;

    @Column(name = "DATE_EXPIRY")
    private LocalDate dateExpiry;


    public ClientDetails() {
    }

    public ClientDetails(String id, String surname, String name, String middleName, LocalDate birthDate, String passportNumber, String identityNumber, String cityBirth, LocalDate dateIssue, LocalDate dateExpiry) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.identityNumber = identityNumber;
        this.cityBirth = cityBirth;
        this.dateIssue = dateIssue;
        this.dateExpiry = dateExpiry;
    }

    //    @Column(name = "NATIONALITY")
//    private String nationality;
//    @JoinColumn(name = "ISSUING_AUTHORITY")
//    @OneToOne(cascade = CascadeType.ALL)
//    private IssuingAuthority issuingAuthority;

    //    @JoinColumn(name = "CLIENT_ID")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Client client;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    public String getCityBirth() {
        return cityBirth;
    }

    public void setCityBirth(String cityBirth) {
        this.cityBirth = cityBirth;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public LocalDate getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDate dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
}
