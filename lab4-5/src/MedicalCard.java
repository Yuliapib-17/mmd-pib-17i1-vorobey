import java.io.Serializable;

public class MedicalCard implements Person, Serializable {
    private final String name;

    public MedicalCard(String name) {
        this.name = name;
    }

    public String getFIO() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}