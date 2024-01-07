package by.nata.data.model;

import java.io.Serializable;

public record FilterClientDto (String username,
                               String email)implements Serializable {
    private static final long serialVersionUID = 3625201250858163171L;

}
