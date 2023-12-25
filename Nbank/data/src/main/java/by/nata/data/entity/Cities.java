package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "CITIES")
public class Cities {
    @Id
    @GenericGenerator(strategy = "uuid", name = "cities_uuid")
    @GeneratedValue(generator = "cities_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    public Cities() {
    }

    public Cities(String id, String name) {
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
