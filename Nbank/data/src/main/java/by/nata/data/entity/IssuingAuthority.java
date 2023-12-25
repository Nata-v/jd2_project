package by.nata.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ISSUING_AUTHORITY")
public class IssuingAuthority {

    @Id
    @GenericGenerator(strategy = "uuid", name = "issuing_authority_uuid")
    @GeneratedValue(generator = "issuing_authority_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;




}
