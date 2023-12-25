package by.nata.service.model;

import by.nata.data.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;


import java.io.Serializable;
@Getter

public class Client implements Serializable {
    private static final long serialVersionUID = 3402708669125589382L;
    private final String id;

    private final String username;
    private final String password;

    private final String email;
    private final Role role;
    private final ClientDetails clientDetails;

    private final ClientAddress clientAddress;

//    public Client() {
//    }

    public Client(String id, String username, String password, String email, Role role, ClientDetails clientDetails, ClientAddress clientAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.clientDetails = clientDetails;
        this.clientAddress = clientAddress;
    }
}
