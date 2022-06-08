package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	    Empresa empresa = new Empresa();
	    empresa.setRazonSocial("Mercado Libre S.A.");

	    Empleado emp1 = new Empleado();
	    emp1.setNombre("Julia");
	    emp1.setApellido("Rodriguez");
	    emp1.setSueldo(130000);

        Empleado emp2 = new Empleado();
        emp2.setNombre("Juan");
        emp2.setApellido("Gonzalez");
        emp2.setSueldo(140000);

        Empleado emp3 = new Empleado();
        emp3.setNombre("Mariana");
        emp3.setApellido("Perez");
        emp3.setSueldo(150000);

        Empleado emp4 = new Empleado();
        emp4.setNombre("Marcelo");
        emp4.setApellido("Guraz");
        emp4.setSueldo(160000);

        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        empresa.agregarEmpleado(emp4);

        //Guardamos todos los empleados de la empresa pero separados por ";"
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream("Empleados.txt");
            BufferedOutputStream buffer = new BufferedOutputStream(fo);

            for(Empleado empleado: empresa.getEmpleados()) {
                //"\n" lo podemos usar para indicar un fin de línea
                String linea = empleado.getNombre() + ";" + empleado.getApellido() + ";" + empleado.getLegajo() + ";" + empleado.getSueldo() + "\n";
                buffer.write(linea.getBytes());
                System.out.println(linea);
            }
            buffer.close();
            fo.close();


        } catch (FileNotFoundException e) {
            System.out.println("ERROR:" + e.getMessage());
        }catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }







    }
}
