package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Objeto {
    private String nombre;
    private String descripcion;
    private int coste;

    public Objeto() {}

    public Objeto(String nombre, String descripcion, int coste) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.coste=coste;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCoste() {
        return coste;
    }
    public void setCoste(int coste) {this.coste = coste;}
}
