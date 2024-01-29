package by.nata.data.model;

import by.nata.data.entity.Role;


import java.io.Serializable;

public  final class ClientDto implements Serializable {
    private static final long serialVersionUID = 5162859898448298928L;

    private final String id;

    private final String username;
    private final String password;
    private final String email;
    private final Role role;
   private final   ClientDetailsDto clientDetailsDto;

    private final ClientAddressDto clientAddressDto;

    public ClientDto(String id, String username, String password, String email, Role role, ClientDetailsDto clientDetailsDto, ClientAddressDto clientAddressDto) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;

        this.clientDetailsDto = clientDetailsDto;
        this.clientAddressDto = clientAddressDto;
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

    public Role getRole() {
        return role;
    }

    public ClientDetailsDto getClientDetailsDto() {
        return clientDetailsDto;
    }

    public ClientAddressDto getClientAddressDto() {
        return clientAddressDto;
    }


    @Override
    public String toString() {
        return "ClientDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", clientDetailsDto=" + clientDetailsDto +
                ", clientAddressDto=" + clientAddressDto +
                '}';
    }
}
