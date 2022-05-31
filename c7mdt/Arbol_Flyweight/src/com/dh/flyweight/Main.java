package com.dh.flyweight;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArbolFactory arbolFactory = new ArbolFactory();

        while(arbolFactory.obtenerCantidadArboles()<1000){
            Arbol arbolVerde = arbolFactory.getArbol("Ornamental");
            Arbol arbolRojo = arbolFactory.getArbol("Frutal Rojo");
            System.out.println(arbolVerde);
            System.out.println(arbolRojo);
        }
        arbolFactory.obtenerCantidadArboles();
    }
}
