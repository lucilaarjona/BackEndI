package com.dh.model;

import java.sql.Date;
import java.util.Objects;

public class Paciente {

    private Integer pacienteID;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Date fechaIngreso;
    private Domicilio domicilio;

    public Paciente() {}

    public Paciente(String nombre, String apellido, Integer dni, Date fechaIngreso, Domicilio domicilio) {
        this.pacienteID = null;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(Integer id, String nombre, String apellido, Integer dni, Date fechaIngreso, Domicilio domicilio) {
        this.pacienteID = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Integer getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return pacienteID.equals(paciente.pacienteID) &&
               Objects.equals(dni, paciente.dni) &&
               Objects.equals(domicilio, paciente.domicilio) &&
               nombre.equals(paciente.nombre) &&
               apellido.equals(paciente.apellido) &&
               fechaIngreso.equals(paciente.fechaIngreso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacienteID, nombre, apellido, dni, fechaIngreso, domicilio);
    }

    @Override
    public String toString() {
        String informacion = "Paciente" +
                "\n\tNombre: '" + nombre + '\'' +
                "\n\tApellido: '" + apellido + '\'' +
                "\n\tDNI: " + dni +
                "\n\tFecha de Ingreso: " + fechaIngreso;
        if (domicilio != null &&
            domicilio.getCalle() != null && domicilio.getNumero() != null &&
            domicilio.getLocalidad() != null && domicilio.getProvincia() != null) {
            informacion += domicilio.toString();
        }
        return informacion;
    }
}
