package edu.upc.dsa;

import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Producto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.util.GameManagerImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameManagerTest {
    @After
    public void tearDown() {
        GameManagerImpl.getInstance().clear();
        GameManagerImpl.delete();
    }


    @Before
    public void setUp() {
        //Añadir objetos disponibles
        GameManagerImpl.getInstance().addObjeto("Espada", "Arma de corto alcance",100); // inicialmente nomes espada
        GameManagerImpl.getInstance().addObjeto("Armadura basica","Armadura de proteccion basica", 50);

        //Crear clientes
        GameManagerImpl.getInstance().addUsuario("Lorena","Garcia","1234","lore@gmail.com",50);
        GameManagerImpl.getInstance().addUsuario("Julia","Alos", "4321", "juls@gmail.com",50);
        GameManagerImpl.getInstance().addUsuario("Paco","Lopez", "abcd", "lopez@gmail.com",50);
    }

    @Test
    public void testListarUsuariosOrdenados(){
        Assert.assertEquals("Julia",GameManagerImpl.getInstance().listarUsuariosOrdenados().get(0).getNombre());

    }

    @Test
    public void testAddUsuario(){

        Assert.assertEquals(3,GameManagerImpl.getInstance().numUsuario());
        GameManagerImpl.getInstance().addUsuario("Eulalia","Fernandez","7654","AlonsoF1@gmail.com",50);
        Assert.assertEquals(4,GameManagerImpl.getInstance().numUsuario());
    }

//    @Test
//    public void testupdateUsuario(){
//        Assert.assertEquals("Alos",GameManagerImpl.getInstance().getUsuario(GameManagerImpl.getInstance().getUsuarioID("Julia")).getApellidos());
//        Usuario updateUser = new Usuario(GameManagerImpl.getInstance().getUsuarioID("Julia"),"Julia","Alonso","7654","AlonsoF1@gmail.com");
//        GameManagerImpl.getInstance().updateUsuario(updateUser);
//        Assert.assertEquals("Alonso",GameManagerImpl.getInstance().getUsuario(GameManagerImpl.getInstance().getUsuarioID("Julia")).getApellidos());
//
//    }

//    @Test
//    public void testAddObjetoUsuario(){
//        Assert.assertEquals(0,GameManagerImpl.getInstance().listadoObjetosUsuario(GameManagerImpl.getInstance().getUsuarioID("Julia")).size());
//        GameManagerImpl.getInstance().addObjetoUsuario(GameManagerImpl.getInstance().getUsuarioID("Julia"),"Moneda");
//
//        Assert.assertEquals(1,GameManagerImpl.getInstance().listadoObjetosUsuario(GameManagerImpl.getInstance().getUsuarioID("Julia")).size());
//
//    }


}
