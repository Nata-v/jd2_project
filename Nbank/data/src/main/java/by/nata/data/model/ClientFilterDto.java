package by.nata.data.model;

import java.io.Serializable;
import java.time.LocalDate;

public record ClientFilterDto(String surname,
                              String name,
                              LocalDate birthDate) implements Serializable {
    private static final long serialVersionUID = -7779463490160607141L;
}
