package edu.upc.dsa.util;


import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface GameManager {
    public List<Usuario> listarUsuariosOrdenados();
    public Usuario addUsuario(String nombreUsuario,String apellidos, String contrasenya, String correo, int saldo);
    public Usuario addUsuario(Usuario usuario);
    //public Usuario updateUsuario(Usuario usuario);
    public int numUsuario();
    //public Usuario consultarInfoUsuario(String id);
    public Integer compraObjetoUsuario(String id,String objeto);
    //public List<Objeto> listadoObjetosTienda();
    public int numObjetosUsuario(String nombreUsuario);

    List<Objeto> listadoObjetosCompradosUsuario(String id);

    public void addObjeto(String nombre, String descripcion, int coste);
    //public String getUsuarioID(String nombre);
    public int numObjetos();
    public Usuario getUsuario(String id);
    public Objeto getObjeto(String nombre);

    //List<Objeto> listadoObjetos(String id);
}
