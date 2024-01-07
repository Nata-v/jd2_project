package by.nata.service.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ClientFilter implements Serializable {
    private static final long serialVersionUID = 2926842073095350429L;

    private String surname;
    private String name;
    private LocalDate birthDate;

    public ClientFilter() {
    }

    public ClientFilter(String surname, String name, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
