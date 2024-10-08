package by.nata.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;


@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GenericGenerator(strategy = "uuid", name = "client_uuid")
    @GeneratedValue(generator = "client_uuid")
    @Column(name = "ID")
    private String id;
    @NotEmpty(message = "Enter username!")
    @Size(min = 3, max = 15, message = "Username must be from 3 to 15 characters!")
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @NotEmpty(message = "Enter password!")
    @Size(min = 3, max = 20, message = "Password must be from 3 to 20 characters!!")
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid!")
    @Column(name = "EMAIL")
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_DETAILS_ID")
    private ClientDetails clientDetails;

    @ManyToOne(cascade = CascadeType.ALL)
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
