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

    @Column(name = "DATE_ISSUE")
    private LocalDate dateIssue;

    @Column(name = "DATE_EXPIRY")
    private LocalDate dateExpiry;


    public ClientDetails() {
    }

    public ClientDetails(String id, String surname, String name, LocalDate birthDate, String passportNumber, String identityNumber, LocalDate dateIssue, LocalDate dateExpiry) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.identityNumber = identityNumber;
        this.dateIssue = dateIssue;
        this.dateExpiry = dateExpiry;
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
