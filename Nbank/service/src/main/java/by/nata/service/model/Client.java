package by.nata.service.model;

import by.nata.data.entity.Role;



import java.io.Serializable;
import java.util.Objects;


public class Client implements Serializable {
    private static  long serialVersionUID = 3402708669125589382L;
    private  String id;

    private  String username;
    private  String password;

    private  String email;
   // private final Role role;
    private  ClientDetails clientDetails;

    private  ClientAddress clientAddress;


    public Client() {
    }

    public Client(String id, String username, String password, String email, ClientDetails clientDetails, ClientAddress clientAddress) {
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

    public static void setSerialVersionUID(long serialVersionUID) {
        Client.serialVersionUID = serialVersionUID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //    public Role getRole() {
//        return role;
//    }

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
    public boolean equals(Object object) {

        if (this == object) return true;
        if (!(object instanceof Client client)) return false;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getUsername(), client.getUsername()) && Objects.equals(getPassword(), client.getPassword()) && Objects.equals(getEmail(), client.getEmail()) && Objects.equals(getClientDetails(), client.getClientDetails()) && Objects.equals(getClientAddress(), client.getClientAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getClientDetails(), getClientAddress());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", clientDetails=" + clientDetails +
                ", clientAddress=" + clientAddress +
                '}';
    }
}
