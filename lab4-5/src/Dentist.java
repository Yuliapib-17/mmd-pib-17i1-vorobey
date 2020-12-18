import java.io.Serializable;

public class Dentist implements Person, Serializable {
    private final String name;
    private final Specialty specialty;

    public Dentist(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @Override
    public String getFIO() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return getFIO() + " - " + specialty;
    }
}