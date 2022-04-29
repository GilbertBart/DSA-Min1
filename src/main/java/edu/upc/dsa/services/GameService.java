package edu.upc.dsa.services;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.util.GameManager;
import edu.upc.dsa.util.GameManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/game", description = "Endpoint to Game Service")
@Path("/game")
public class GameService {

    private GameManager manager;

    public GameService() {
        this.manager = GameManagerImpl.getInstance();

        if (manager.numObjetos()==0) {
            //Añadir objetos disponibles
            GameManagerImpl.getInstance().addObjeto("Espada","Arma de corto alcance",100);
            GameManagerImpl.getInstance().addObjeto("Armadura basica","Armadura de proteccion basica", 50);
        }
        if(manager.numUsuario()==0) {

            //Crear clientes
            GameManagerImpl.getInstance().addUsuario("Lorena","Garcia","1234","lore@gmail.com",50);
            GameManagerImpl.getInstance().addUsuario("Julia","Alos", "4321", "juls@gmail.com",50);
            GameManagerImpl.getInstance().addUsuario("Paco","Lopez", "abcd", "lopez@gmail.com",50);
        }

    }

    @GET
    @ApiOperation(value = "get list users ordenats alfabeticament", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de usuarios no encontrada (está vacía)")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuariosOrdenados(){

        List<Usuario> usuarioList = this.manager.listarUsuariosOrdenados();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usuarioList) {};

        if(usuarioList.size() > 0)
            return Response.status(201).entity(entity).build();
        return Response.status(404).entity(entity).build();
    }

    @POST
    @ApiOperation(value = "add a new Usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario user) {
        if (user.getNombre()==null || user.getApellidos()==null)  return Response.status(500).entity(user).build();
        this.manager.addUsuario(user);
        return Response.status(201).entity(user).build();
    }


//    @PUT
//    @ApiOperation(value = "update a Usuario", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful"),
//            @ApiResponse(code = 404, message = "Usuario not found")
//    })
//    @Path("/")
//    public Response updateUsuario(Usuario user) {
//
//        Usuario u = this.manager.updateUsuario(user);
//
//        if (u == null) return Response.status(404).build();
//
//        return Response.status(201).build();
//    }

//    @GET
//    @ApiOperation(value = "get info user", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
//            @ApiResponse(code = 404, message = "Usuario not found")
//    })
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response consultarInfoUsuario(@PathParam("id") String id) {
//        Usuario user = this.manager.consultarInfoUsuario(id);
//        if (user == null) return Response.status(404).build();
//        else  return Response.status(201).entity(user).build();
//    }


    @GET
    @ApiOperation(value = "get all objetos Usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "Lista de objetos no encontrada (está vacía)")
    })


    @Path("/getObjetos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listadoObjetosUsuario(@PathParam("id") String id){

        List<Objeto> objetoList = this.manager.listadoObjetos(id);
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetoList) {};

        if(objetoList.size() > 0)
            return Response.status(201).entity(entity).build();
        else
            return Response.status(404).entity(entity).build();
    }


//    @PUT
//    @ApiOperation(value = "Add objeto a Usuario", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Integer.class),
//            @ApiResponse(code = 404, message = "User not found")
//    })
//    @Path("/AddObjeto/{idUser}/{idObjeto}/{idDescripcion}")
//    public Response addObjetoUsuario(@PathParam("idUser") String idUser, @PathParam("idObjeto") String idObjeto,@PathParam("idDescripcion") String idDescripcion) {
//
//        Integer res=this.manager.addObjeto(idUser,idObjeto,idDescripcion);
//
//        if (res!=0) return Response.status(404).build();
//        return Response.status(201).build();
//    }








}