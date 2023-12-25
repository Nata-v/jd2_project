package by.nata.data.model;

import by.nata.data.entity.ClientAddress;
import by.nata.data.entity.ClientDetails;
import by.nata.data.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
@Getter
public final class ClientDto implements Serializable {
    private static final long serialVersionUID = 5162859898448298928L;

    private final String id;

    private final String username;
    private final String password;
    private final String email;
    private final Role role;
    private final ClientDetails clientDetails;

    private final ClientAddress clientAddress;

    public ClientDto(String id, String username, String password,  String email, Role role, ClientDetails clientDetails, ClientAddress clientAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.clientDetails = clientDetails;
        this.clientAddress = clientAddress;
    }
}
