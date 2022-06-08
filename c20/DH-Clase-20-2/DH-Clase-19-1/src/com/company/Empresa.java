package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {

    private String cuit;
    private String razonSocial;
    private ArrayList<Empleado> empleados;

    public Empresa(){
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado)
    {
        empleados.add(empleado);
    }

    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
