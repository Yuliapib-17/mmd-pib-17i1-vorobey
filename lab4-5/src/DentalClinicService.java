import java.io.*;

public class DentalClinicService {

    public static void write(DentalClinic dentalclinic) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("inputClinic.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(dentalclinic);
        }
    }

    public static DentalClinic reader() throws Exception {
        try (FileInputStream fis = new FileInputStream("inputClinic.txt");
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)
        ) {
            return (DentalClinic) ois.readObject();
        }
    }

}