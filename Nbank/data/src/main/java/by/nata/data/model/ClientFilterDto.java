package by.nata.data.model;

import java.io.Serializable;
import java.time.LocalDate;

public final class ClientFilterDto implements Serializable {
    private static final long serialVersionUID = -7779463490160607141L;

    private final String surname;
    private final String name;
    private final LocalDate birthDate;

    public ClientFilterDto(String surname, String name, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
