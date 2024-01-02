package by.nata.service.model;




import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ClientDetails implements Serializable {

    private static final long serialVersionUID = 4965439671051563406L;

    private  String id;
   // private final Client client;
    private  String surname;
    private  String name;
    private  String middleName;
    //@DateTimeFormat(pattern = "dd-MM-yyy")
    private  LocalDate birthDate;
    private  String passportNumber;
    private  String identityNumber;
    //private  Cities city;
    private String cityBirth;
    private  LocalDate dateIssue;
    private  LocalDate dateExpiry;

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

    @Override
    public String toString() {
        return "ClientDetails{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", passportNumber='" + passportNumber + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", cityBirth='" + cityBirth + '\'' +
                ", dateIssue=" + dateIssue +
                ", dateExpiry=" + dateExpiry +
                '}';
    }
}
