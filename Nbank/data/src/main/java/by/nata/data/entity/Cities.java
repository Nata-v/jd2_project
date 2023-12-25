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
@Table(name = "CITIES")
public class Cities {
    @Id
    @GenericGenerator(strategy = "uuid", name = "cities_uuid")
    @GeneratedValue(generator = "cities_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

}
