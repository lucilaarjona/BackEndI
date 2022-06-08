package com.dh.ventas;

import java.util.ArrayList;

public class Empleado extends Vendedor {

    private int aniosAntiguedad;

    private ArrayList<Vendedor> afiliados = new ArrayList<>();

    public Empleado(String nombre, int aniosAntiguedad){
        super.nombre = nombre;
        super.PUNTOS_POR_VENTA = 5;
        this.aniosAntiguedad = aniosAntiguedad;
    }

    /*agrega un afiliado al empleado, y a su vez suma los puntos*/
     public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
        //System.out.println(afiliado.nombre+ " ahora es afiliado de "+super.nombre);
     }

    /*implementacion de metodo abstracto*/
    /*por cada anio de antiguedad obtiene 5 puntos, por cada afiliado obtiene 5*/
    @Override
    public int calcularPuntos() {

        return (this.afiliados.size()*10) + (this.aniosAntiguedad*5);
    }
}
