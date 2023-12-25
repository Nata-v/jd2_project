package by.nata.service.model;


import java.io.Serializable;


public class Cities implements Serializable {
    private static final long serialVersionUID = -8458640612453928867L;
    private final String id;
    private final String name;

    public Cities(String id, String name) {
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
