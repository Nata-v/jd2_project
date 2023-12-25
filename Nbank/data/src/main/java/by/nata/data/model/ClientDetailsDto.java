package by.nata.data.model;

import by.nata.data.entity.Cities;
import by.nata.data.entity.IssuingAuthority;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
@Getter
public final class ClientDetailsDto implements Serializable {
    private static final long serialVersionUID = -5986222759178415490L;

    private final String id;

    private final String surname;
    private final String name;
    private final String middleName;
    private final Date birthDate;
    private final String passportNumber;
    private final String identityNumber;
    private final Cities city;
    private final Date dateIssue;
    private final Date dateExpiry;
    private final String nationality;
    private final IssuingAuthority issuingAuthority;

    public ClientDetailsDto(String id, String surname, String name, String middleName, Date birthDate, String passportNumber, String identityNumber, Cities city, Date dateIssue, Date dateExpiry, String nationality, IssuingAuthority issuingAuthority) {
        this.id = id;
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
}
