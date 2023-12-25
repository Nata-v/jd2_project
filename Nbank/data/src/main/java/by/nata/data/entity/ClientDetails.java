package by.nata.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
