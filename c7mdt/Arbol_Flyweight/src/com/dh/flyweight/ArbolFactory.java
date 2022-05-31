package com.dh.flyweight;
import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map <String, Arbol> ARBOL_MAP = new HashMap<>();

    public Arbol getArbol(String tipo){
        Arbol arbol = new Arbol(tipo);

        String clave = "Key:"+ arbol.getAlto() + ":"+ arbol.getAncho() +":"+ arbol.getColor();
        System.out.println(clave);
        if (!ARBOL_MAP.containsKey(clave)){
            ARBOL_MAP.put(clave, arbol);
            System.out.println("Arbol plantado.");
            return ARBOL_MAP.get(clave);
        }
        System.out.println("**Arbol obtenido del Hashmap**");
        return ARBOL_MAP.get(clave);
    }

    public Arbol getArbol2(int alto, int ancho, String color, String tipoArbol){
        Arbol arbol = new Arbol(alto,ancho,color,tipoArbol);

        String clave = "Key:"+ arbol.getAlto() + ":"+ arbol.getAncho() +":"+ arbol.getColor();
        System.out.println(clave);
        if (!ARBOL_MAP.containsKey(clave)){
            ARBOL_MAP.put(clave, arbol);
            System.out.println("Árbol plantado");
            return ARBOL_MAP.get(clave);
        }
        System.out.println("Arbol obtenido del Hashmap");
        return ARBOL_MAP.get(clave);
    }

    public int obtenerCantidadArboles(){
        System.out.println("Se han plantado: " + ARBOL_MAP.size() + " árboles.");
        return ARBOL_MAP.size();
    }
}
