package by.nata.data.model;

import by.nata.data.entity.ClientAddress;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Role;


import java.io.Serializable;
import java.util.Objects;

public final class ClientDto implements Serializable {
    private static final long serialVersionUID = 5162859898448298928L;

    private final String id;

    private final String username;
    private final String password;
    private final String email;
   // private final Role role;
   private final ClientDetails clientDetails;

    private final ClientAddress clientAddress;


    public ClientDto(String id, String username, String password, String email, ClientDetails clientDetails, ClientAddress clientAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.clientDetails = clientDetails;
        this.clientAddress = clientAddress;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

//    public Role getRole() {
//        return role;
//    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public ClientAddress getClientAddress() {
        return clientAddress;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ClientDto clientDto)) return false;
        return Objects.equals(getId(), clientDto.getId()) && Objects.equals(getUsername(), clientDto.getUsername()) && Objects.equals(getPassword(), clientDto.getPassword()) && Objects.equals(getEmail(), clientDto.getEmail()) && Objects.equals(getClientDetails(), clientDto.getClientDetails()) && Objects.equals(getClientAddress(), clientDto.getClientAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getClientDetails(), getClientAddress());
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", clientDetails=" + clientDetails +
                ", clientAddress=" + clientAddress +
                '}';
    }
}
