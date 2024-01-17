package by.nata.data.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;


@Entity
@Table(name = "CLIENT")
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
        @OneToOne(cascade = CascadeType.ALL) //, fetch = FetchType.LAZY)
        @JoinColumn(name = "CLIENT_DETAILS_ID")
        private ClientDetails clientDetails;

        @ManyToOne(cascade = CascadeType.ALL) //, fetch = FetchType.LAZY)
        @JoinColumn(name = "CLIENT_ADDRESS_ID")
        private ClientAddress clientAddress;

        public Client() {
        }

        public Client(String id, String username, String password, String email, Role role, ClientDetails clientDetails, ClientAddress clientAddress) {
                this.id = id;
                this.username = username;
                this.password = password;
                this.email = email;
                this.role = role;
                this.clientDetails = clientDetails;
                this.clientAddress = clientAddress;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Role getRole() {
                return role;
        }

        public void setRole(Role role) {
                this.role = role;
        }

        public ClientDetails getClientDetails() {
                return clientDetails;
        }

        public void setClientDetails(ClientDetails clientDetails) {
                this.clientDetails = clientDetails;
        }

        public ClientAddress getClientAddress() {
                return clientAddress;
        }

        public void setClientAddress(ClientAddress clientAddress) {
                this.clientAddress = clientAddress;
        }

        @Override
        public String toString() {
                return "Client{" +
                        "id='" + id + '\'' +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        ", role=" + role +
                        ", clientDetails=" + clientDetails +
                        ", clientAddress=" + clientAddress +
                        '}';
        }

        @Override
        public boolean equals(Object object) {
                if (this == object) return true;
                if (!(object instanceof Client client)) return false;
                return Objects.equals(getId(), client.getId()) && Objects.equals(getUsername(), client.getUsername()) && Objects.equals(getPassword(), client.getPassword()) && Objects.equals(getEmail(), client.getEmail()) && getRole() == client.getRole() && Objects.equals(getClientDetails(), client.getClientDetails()) && Objects.equals(getClientAddress(), client.getClientAddress());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getRole(), getClientDetails(), getClientAddress());
        }
}
