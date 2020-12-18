import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DentalClinic implements Serializable {

    private final List<Visit> visits = new ArrayList<>();
    private final List<MedicalCard> patients = new ArrayList<>();
    private final List<Dentist> dentists = new ArrayList<>();

    public DentalClinic() {
        this.dentists.add(new Dentist("Oleg", Specialty.THERAPIST));
        this.dentists.add(new Dentist("Sofia", Specialty.SURGEON));
        this.dentists.add(new Dentist("Alex", Specialty.ORTODONTIST));
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public List<MedicalCard> getPatients() {

        return patients;
    }

    public List<Dentist> getDentists() {
        return dentists;
    }

    public void addPatient(MedicalCard medicalCard) {
        patients.add(medicalCard);
    }

    public void addVisit(Visit newVisit) throws Exception {
        for (Visit visit : visits) {
            if (visit.getDentist() == newVisit.getDentist() && visit.getDate().equals(newVisit.getDate())) {
                throw new Exception("Стоматолог занят");
            }
        }
        visits.add(newVisit);
    }

    public void addDentist(Dentist newDentist) {
        dentists.add(newDentist);
    }

}