package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ObjetoUsuario implements Comparable<ObjetoUsuario> {
    private Objeto objeto;
    private LocalDateTime fecha;

    ObjetoUsuario(){}

    ObjetoUsuario(Objeto objeto){
        this();
        this.objeto=objeto;
        this.fecha=LocalDateTime.now();
    }

    public int compareTo(ObjetoUsuario g){
        return Math.toIntExact(ChronoUnit.SECONDS.between(g.getFecha(),this.fecha));

    }

    private LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public Objeto getObjeto(){
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
}
