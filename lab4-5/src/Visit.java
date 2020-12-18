import java.io.Serializable;
import java.time.LocalDate;

public class Visit implements Serializable {
    private final MedicalCard patient;
    private final Dentist dentist;
    private final LocalDate date;

    public Visit(MedicalCard patient, Dentist dentist, LocalDate date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public MedicalCard getPatient() {
        return patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + ":" +
                "Пациент - " + patient +
                ", Стоматолог - " + dentist.getFIO();
    }
}