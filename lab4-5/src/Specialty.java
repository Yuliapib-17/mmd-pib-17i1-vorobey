public enum Specialty {
    THERAPIST("Терапевт"),
    ORTOPEDIC("Ортопед"),
    ORTODONTIST("Ортодонт"),
    SURGEON("Хирург");

    private final String name;

    Specialty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}