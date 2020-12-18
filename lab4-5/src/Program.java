import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        DentalClinic dentalclinic = new DentalClinic();
        String userInput;
        do {
            System.out.println("Выберите действие из меню:" +
                    "\n1.Работа с медицинскими карточками пациентов стоматологической клиники" +
                    "\n2.Работа с врачами стоматологической клиники" +
                    "\n3.Работа с посещениями" +
                    "\n4.Добавить данные в файл" +
                    "\n5.Выгрузить данные из файла" +
                    "\n6.Выйти из меню");
            userInput = IN.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("Что вы хотите сделать?" +
                            "\n1.Добавить пациента" +
                            "\n2.Посмотреть список всех пациентов");
                    String case1Switch = IN.nextLine();
                    switch (case1Switch) {
                        case "1":
                            createPatient(dentalclinic);
                            printPatients(dentalclinic);
                            break;

                        case "2":
                            printPatients(dentalclinic);
                            break;
                        default:
                            System.out.println("Выберите из имеющихся вариантов");
                    }
                    break;

                case "2":
                    System.out.println("Что вы хотите сделать?" +
                            "\n1.Добавить стоматолога" +
                            "\n2.Посмотреть список всех стоматологов клиники");
                    String case2Switch = IN.nextLine();
                    switch (case2Switch) {
                        case "1":
                            createDentists(dentalclinic);
                            printDentists(dentalclinic);
                            break;
                        case "2":
                            printDentists(dentalclinic);
                            break;
                        default:
                            System.out.println("Выберите из имеющихся вариантов");
                    }
                    break;

                case "3":
                    System.out.println("Что вы хотите сделать?" +
                            "\n1.Добавить новое посещение" +
                            "\n2.Посмотреть список всех посещений стоматологической клиники");
                    String case3Switch = IN.nextLine();
                    switch (case3Switch) {
                        case "1":
                            createVisit(dentalclinic);
                            printVisit(dentalclinic);
                            break;
                        case "2":
                            printVisit(dentalclinic);
                            break;
                        default:
                            System.out.println("Выберите из имеющихся вариантов");
                    }
                    break;
                case "4":
                    DentalClinicService.write(dentalclinic);
                    System.out.println("Данные записаны");
                    break;
                case "5":
                    System.out.println("Если вы не сохранили данные, то они будут удалены" +
                            "\nДальше?" +
                            "\n1.Да" +
                            "\n2.Нет");
                    String case5Switch = IN.nextLine();
                    switch (case5Switch) {
                        case "1":
                            dentalclinic = DentalClinicService.reader();
                            System.out.println("Данные добавлены");
                            break;
                        case "2":
                            break;
                        default:
                            System.out.println("Выберите из имеющихся вариантов");
                    }
                    break;
                case "6":
                    System.out.println("Спасибо!");
                    break;
                default:
                    System.out.println("Выберите из имеющихся вариантов");
                    break;
            }
        } while (!"6".equals(userInput));
    }

    private static void printPatients(DentalClinic dentalclinic) {
        System.out.println("Список всех пациентов стоматологической клиники:");
        for (int i = 0; i < dentalclinic.getPatients().size(); ++i) {
            MedicalCard medicalCard = dentalclinic.getPatients().get(i);
            System.out.println(i + ". " + medicalCard);
        }
    }

    private static void createPatient(DentalClinic dentalclinic) {
        System.out.println("Добавьте нового пациента");
        String patientName = IN.nextLine();
        MedicalCard newMedicalCard = new MedicalCard(patientName);
        dentalclinic.addPatient(newMedicalCard);
    }

    private static void printDentists(DentalClinic dentalclinic) {
        System.out.println("Список всех стоматологов:");
        for (int i = 0; i < dentalclinic.getDentists().size(); ++i) {
            Dentist dentist = dentalclinic.getDentists().get(i);
            System.out.println(i + ". " + dentist);
        }
    }

    private static void createVisit(DentalClinic dentalclinic) {
        System.out.println("Выберите стоматолога:");
        printDentists(dentalclinic);
        String dentistIndexAsString = IN.nextLine();
        int dentistIndex = Integer.parseInt(dentistIndexAsString);
        System.out.println("Выберите пациента:");
        printPatients(dentalclinic);
        String patientIndexAsString = IN.nextLine();
        int patientIndex = Integer.parseInt(patientIndexAsString);
        System.out.println("Введите дату посещения (формат: гггг-мм-дд)");
        String dateAsString = IN.nextLine();
        LocalDate date = LocalDate.parse(dateAsString);
        Dentist dentist = dentalclinic.getDentists().get(dentistIndex);
        MedicalCard patient = dentalclinic.getPatients().get(patientIndex);
        Visit visit = new Visit(patient, dentist, date);
        try {
            dentalclinic.addVisit(visit);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printVisit(DentalClinic dentalclinic) {
        System.out.println("Список посещений:");
        for (Visit visit : dentalclinic.getVisits()) {
            System.out.println(visit);
        }
    }

    private static void createDentists(DentalClinic dentalclinic) {
        System.out.println("Введите имя стоматолога");
        String denName = IN.nextLine();
        System.out.println("Выберите направление стоматолога");
        Specialty[] specialty = Specialty.values();
        for (int i = 0; i < Specialty.values().length; ++i) {
            System.out.println(i + ". " + specialty[i]);
        }
        String specChoice = IN.nextLine();
        int specChoiceInt = Integer.parseInt(specChoice);
        Dentist newDentist = new Dentist(denName, specialty[specChoiceInt]);
        dentalclinic.addDentist(newDentist);
    }
}