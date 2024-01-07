package by.nata.service.model;

import java.io.Serializable;

public class FilterClient implements Serializable {

    private static final long serialVersionUID = 762143110353409500L;

    private String username;
    private String email;

    public FilterClient(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public FilterClient() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
