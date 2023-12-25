package by.nata.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data  //гетеры и сеттеры иквал хеш код и тостринг
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENT")

public class Client {
        @Id
        @GenericGenerator(strategy = "uuid", name = "client_uuid")
        @GeneratedValue(generator = "client_uuid")
        @Column(name = "ID")
        private String id;

        @Column(name = "USERNAME", nullable = false, unique = true)
        private String username;
        @Column(name = "PASSWORD", nullable = false, unique = true)
        private String password;
        @Column(name = "EMAIL", unique = true)
        private String email;
        @Enumerated(EnumType.STRING)
        @Column(name = "role")
        private Role role;
        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "CLIENT_DETAILS_ID")
        private ClientDetails clientDetails;

        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "CLIENT_ADDRESS_ID")
        private ClientAddress clientAddress;
}
