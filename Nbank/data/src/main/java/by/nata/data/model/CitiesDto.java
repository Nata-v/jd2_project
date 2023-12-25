package by.nata.data.model;

import jakarta.persistence.Column;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CitiesDto implements Serializable {
    private static final long serialVersionUID = -1894499881268199722L;
    private final String id;
    private final String name;

    public CitiesDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
