package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


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

    public IssuingAuthority() {
    }

    public IssuingAuthority(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
