package by.nata.service.model;



import java.io.Serializable;

public class IssuingAuthority implements Serializable {
    private static final long serialVersionUID = -4940313289215610911L;

    private final String id;

    private final String name;

    public IssuingAuthority(String id, String name) {
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
