import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Perro> listaPerros = new ArrayList<>();

        Perro perro1 = new Perro();
        perro1.setNombre("Pichicho");
        perro1.setEdad(4);

        //System.out.println(perro1.getEdad()); // la propiedades de tipo de clase y no le seteo un valor por defeto da null
        //System.out.println(perro1.getNombre()); // si es dato primitivo va decolver un valor aunque no se lo haya dado

        Perro perro2 = new Perro();
        perro2.setNombre("Sultan");
        perro2.setEdad(7);

        listaPerros.add(perro1);
        listaPerros.add(perro2);

        FileOutputStream fo;
        try{
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);
            dos.writeObject(listaPerros);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Perro> listaPerros2 = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            listaPerros2 = (List<Perro>) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Perro perro: listaPerros2);
        System.out.println(perro1.getNombre()+" "+perro1.getEdad());
    }
}
