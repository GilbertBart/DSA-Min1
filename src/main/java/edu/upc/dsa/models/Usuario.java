package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;
    //private String fechanacimiento;
    private String contrasenya;
    private int saldo;


    private List<Objeto> listaObjetos = new LinkedList<>();

    public Usuario() {
        this.id = RandomUtils.getId();
    }

    public Usuario(String nombre, String apellidos, String contrasenya, String correo, int saldo) {
        this();
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setContrasenya(contrasenya);
        this.setCorreo(correo);
        this.saldo=50;
    }
    public Usuario(String id,String nombre, String apellidos, String contrasenya, String correo){
        this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.contrasenya=contrasenya;
        this.correo=correo;
    }

    public void addObjetoLista(Objeto objeto){
        String name = objeto.getNombre();
        String descripcion = objeto.getDescripcion();
        int coste = objeto.getCoste();
        listaObjetos.add(new Objeto(name,descripcion,coste));
    }

//    public List<Objeto> listObjetoFecha(){
//        Collections.sort(listaObjetos);
//        List<Objeto> listaOrdenada = new LinkedList<Objeto>();
//        for (ObjetoUsuario obj: this.listaObjetos) {
//            listaOrdenada.add(obj.getObjeto());
//        }
//        return listaOrdenada;
//    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenya() {
        return contrasenya;
    }
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {this.saldo = saldo;}



    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }
    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
}
