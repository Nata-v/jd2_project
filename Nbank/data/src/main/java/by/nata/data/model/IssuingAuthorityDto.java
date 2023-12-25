package by.nata.data.model;



import java.io.Serializable;

public class IssuingAuthorityDto implements Serializable {
    private static final long serialVersionUID = -9042942834034633933L;

    private final String id;

    private final String name;

    public IssuingAuthorityDto(String id, String name) {
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
