package by.nata.data.model;

import java.io.Serializable;

public record LoginDto(String username, String password) implements Serializable {

    private static final long serialVersionUID = -8012228149908630015L;
}
