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
    private  Role role;
    private ClientDetails clientDetails;

    private  ClientAddress clientAddress;


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


}
