package edu.upc.dsa.util;

import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class GameManagerImpl implements GameManager{

    private static GameManagerImpl manager;
    private HashMap<String, Usuario> gameUsers;
    private HashMap<String, Objeto> catalogoObjetos;
    private List<Objeto> objetos;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);



    private GameManagerImpl(){
        this.catalogoObjetos=new HashMap<>();
        this.gameUsers = new HashMap<>();
        this.objetos= new LinkedList<Objeto>();}

    public static GameManagerImpl getInstance(){
        if(manager==null){
            logger.info("New instance edu.upc.dsa.GameManagerImpl");
            manager = new GameManagerImpl();
        }
        return manager;
    }

    public static void delete(){
        manager = null;
        logger.info("Instance GameManagerImpl deleted");
    }

    public void clear(){
        gameUsers.clear();
        objetos.clear();
    }

    @Override
    public List<Usuario> listarUsuariosOrdenados() {
        logger.info("sort users alphabetically by name");
        List<Usuario> usuariosOrdenados = this.gameUsers.values().stream().sorted(
                Comparator.comparing(n->n.getNombre())).collect(Collectors.toList());
        return usuariosOrdenados;
    }

    @Override
    public Usuario addUsuario(String nombreUsuario, String apellidos, String contrasenya, String correo, int saldo) {
        return this.addUsuario(new Usuario(nombreUsuario,apellidos,contrasenya,correo, saldo));
    }
    public Usuario addUsuario(Usuario user) {
        logger.info("new user " + user);
        this.gameUsers.put(user.getId(), user);
        logger.info("new user added");
        return user;
    }

//    @Override
//    public Usuario updateUsuario(Usuario usuario) {
//        Usuario user = this.gameUsers.get(usuario.getId());
//
//        if (user!=null) {
//            logger.info(usuario+" rebut!!!! ");
//
//            user.setNombre(usuario.getNombre());
//            user.setApellidos(usuario.getApellidos());
//
//            logger.info(user+" updated ");
//            return usuario;
//        }
//
//        logger.warn("not found "+usuario);
//        return null;
//
//    }

    @Override
    public int numUsuario() {
        int ret = this.gameUsers.size();
        logger.info("size " + ret);
        return ret;
    }

//    @Override
//    public Usuario consultarInfoUsuario(String id) {
//        logger.info("get user ("+id+")");
//        Usuario user = this.gameUsers.get(id);
//        if(user!=null){
//            logger.info("get user ("+id+"): "+user);
//            return user;
//        }
//
//        logger.warn("not found " + id);
//        return null;
//    }

    @Override
    public Integer compraObjetoUsuario(String id, String objeto) {
        Usuario usuario = this.gameUsers.get(id);
        logger.info("usuario id para objeto: "+usuario.getNombre());

        for(Objeto obj: manager.objetos){
            if(obj.getNombre().equals(objeto)&&obj.getCoste()<usuario.getSaldo()){
                logger.info("objeto2: "+objeto+" encontrado: " +obj.getNombre());
                usuario.addObjetoLista(obj);
                usuario.setSaldo(obj.getCoste()-usuario.getSaldo());

                return 0;

            }
            logger.info("objeto: "+objeto+" encontrado: " +obj.getNombre());
        }

        logger.warn("user or object not found");
        return -1;
    }

    @Override
    public int numObjetosUsuario(String nombreUsuario) {
        return 0;
    }

//    @Override
//    public List<Objeto> listadoObjetosTienda() {
//        List<Objeto> userObjects = this.gameUsers.get(id).listObjetoFecha();
//        if(userObjects.size()!=0)
//            logger.info("User "+id+" "+userObjects);
//        else
//            logger.warn("user or object not found");
//
//        return userObjects;
//    }

    @Override
    public List<Objeto> listadoObjetosCompradosUsuario(String id) {

        Usuario usuario = this.gameUsers.get(id);
        return usuario.getListaObjetos();
    }

    @Override
    public void addObjeto (String nombre, String descripcion, int coste){
        catalogoObjetos.put(nombre,new Objeto(nombre,descripcion,coste));
        logger.info("add object "+nombre);
    }
//    @Override
//    public void realizarCompra(Usuario comprador, String name) {
//        Objeto objetoComprado = catalogoObjetos.get(name);   //add-> retona exepcio si cua plena
//
//        //offer-> retona false
//
//    }



//    @Override
//    public String getUsuarioID(String nombreUsuario){
//        String idUsuario= this.gameUsers.entrySet()
//                .stream()
//                .filter(entry -> Objects.equals(entry.getValue().getNombre(), nombreUsuario))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList()).get(0);
//        if (idUsuario!=null){
//            logger.info("Usuario ("+nombreUsuario+") ID: "+idUsuario);
//            return idUsuario;
//        }
//        logger.warn("User not found");
//        return null;
//
//    }
    public Usuario getUsuario(String id){
        return gameUsers.get(id);

    }
    public Objeto getObjeto(String nombre){
        logger.info("objeto: "+nombre+" encontrado: "+objetos.stream().filter(n->n.getNombre()==nombre).collect(Collectors.toList()).get(0).getNombre());
        return objetos.stream().filter(n->n.getNombre()==nombre).collect(Collectors.toList()).get(0);
    }

    public int numObjetos(){
        return objetos.size();
    }
}
