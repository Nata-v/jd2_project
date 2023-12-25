package by.nata.data.model;


import java.io.Serializable;


public class CitiesDto implements Serializable {
    private static final long serialVersionUID = -1894499881268199722L;
    private final String id;
    private final String name;

    public CitiesDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
