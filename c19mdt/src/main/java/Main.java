import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contacto> listaContactos = new ArrayList<>();

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Adrian");
        contacto1.setMail("adriancito123@gmai.com");
        contacto1.setTelefono("123456");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Isabela");
        contacto2.setMail("isabelita123@gmail");
        contacto2.setTelefono("987654");

        listaContactos.add(contacto1);
        listaContactos.add(contacto2);

        FileOutputStream fo;
        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);
            dos.writeObject(listaContactos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Contacto> listaContactos2 = null;
        FileInputStream fi = null;
        try{
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            listaContactos2 = (List<Contacto>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Contacto contacto: listaContactos2);
        System.out.println(cdlistaContactos);

    }
}
