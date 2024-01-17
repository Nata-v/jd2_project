package by.nata.data.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public final class ClientDetailsDto implements Serializable {
    private static final long serialVersionUID = -5986222759178415490L;

    private final String id;
//private final Client client;
    private final String surname;
    private final String name;
    private final LocalDate birthDate;
    private final String passportNumber;
    private final String identityNumber;
    private final LocalDate dateIssue;
    private final LocalDate dateExpiry;



    public ClientDetailsDto(String id, String surname, String name, LocalDate birthDate, String passportNumber, String identityNumber, LocalDate dateIssue, LocalDate dateExpiry) {
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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public LocalDate getDateExpiry() {
        return dateExpiry;
    }


}
