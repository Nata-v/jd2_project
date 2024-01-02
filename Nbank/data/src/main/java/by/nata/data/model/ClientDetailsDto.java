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
    private final String middleName;
    private final LocalDate birthDate;
    private final String passportNumber;
    private final String identityNumber;
    //private final Cities city;
    private final String cityBirth;
    private final LocalDate dateIssue;
    private final LocalDate dateExpiry;



    public ClientDetailsDto(String id, String surname, String name, String middleName, LocalDate birthDate, String passportNumber, String identityNumber, String cityBirth, LocalDate dateIssue, LocalDate dateExpiry) {
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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
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

    public String getCityBirth() {
        return cityBirth;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public LocalDate getDateExpiry() {
        return dateExpiry;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ClientDetailsDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getName(), that.getName()) && Objects.equals(getMiddleName(), that.getMiddleName()) && Objects.equals(getBirthDate(), that.getBirthDate()) && Objects.equals(getPassportNumber(), that.getPassportNumber()) && Objects.equals(getIdentityNumber(), that.getIdentityNumber()) && Objects.equals(getCityBirth(), that.getCityBirth()) && Objects.equals(getDateIssue(), that.getDateIssue()) && Objects.equals(getDateExpiry(), that.getDateExpiry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getName(), getMiddleName(), getBirthDate(), getPassportNumber(), getIdentityNumber(), getCityBirth(), getDateIssue(), getDateExpiry());
    }

    @Override
    public String toString() {
        return "ClientDetailsDto{" +
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
