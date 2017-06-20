/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.AgendaDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author oliveira
 */
@Path("produto")
public class Agenda {

//    @GET
//    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Produto getProdutoPorId(@PathParam(value = "id") int id) {
//        
//        return new ProdutoDao().getProdutoPorId(id);
//    }
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<modelos.Agenda> getProdutos() {
        return new AgendaDAO().getEstados();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public modelos.Agenda getProdutos(@PathParam(value = "id") String times) {
        AgendaDAO agenda = new AgendaDAO();
        return agenda.getTime(times);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterar(modelos.Agenda estado) {
        AgendaDAO agenda = new AgendaDAO();
        agenda.alterarTime(estado);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionar(modelos.Agenda estado) {
        AgendaDAO agenda = new AgendaDAO();
        agenda.programarTime(estado);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void apagar(@PathParam(value = "id") int id) {
        AgendaDAO agenda = new AgendaDAO();
        agenda.apagarTime(id);
    }

}
