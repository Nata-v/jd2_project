package by.nata.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "CLIENT_DETAILS")
public class ClientDetails {

    @Id
    @GenericGenerator(strategy = "uuid", name = "client_details_uuid")
    @GeneratedValue(generator = "client_details_uuid")
    @Column(name = "ID")
    private String id;

    @NotEmpty(message = "Enter surname!")
    @Size(min = 2, max = 20, message = "Surname must be from 6 to 20 characters!!")
    @Column(name = "SURNAME")
    private String surname;
    @NotEmpty(message = "Enter name!")
    @Size(min = 2, max = 20, message = "Name must be from 2 to 20 characters!!")
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;
    @Column(name = "IDENTITY_NUMBER")
    private String identityNumber;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ClientDetails that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getName(), that.getName()) && Objects.equals(getBirthDate(), that.getBirthDate()) && Objects.equals(getPassportNumber(), that.getPassportNumber()) && Objects.equals(getIdentityNumber(), that.getIdentityNumber()) && Objects.equals(getDateIssue(), that.getDateIssue()) && Objects.equals(getDateExpiry(), that.getDateExpiry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getName(), getBirthDate(), getPassportNumber(), getIdentityNumber(), getDateIssue(), getDateExpiry());
    }

    @Override
    public String toString() {
        return "ClientDetails{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", passportNumber='" + passportNumber + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", dateIssue=" + dateIssue +
                ", dateExpiry=" + dateExpiry +
                '}';
    }
}
