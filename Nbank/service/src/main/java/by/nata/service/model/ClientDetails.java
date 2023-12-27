package by.nata.service.model;




import java.io.Serializable;
import java.util.Date;

public class ClientDetails implements Serializable {

    private static final long serialVersionUID = 4965439671051563406L;

    private final String id;
   // private final Client client;
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



    public ClientDetails(String id,  String surname, String name, String middleName, Date birthDate, String passportNumber, String identityNumber, Cities city, Date dateIssue, Date dateExpiry, String nationality, IssuingAuthority issuingAuthority) {
        this.id = id;
       // this.client = client;
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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public Cities getCity() {
        return city;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public Date getDateExpiry() {
        return dateExpiry;
    }

    public String getNationality() {
        return nationality;
    }

    public IssuingAuthority getIssuingAuthority() {
        return issuingAuthority;
    }


}
