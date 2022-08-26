package br.unitins.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Pessoa;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;

@Path("/pessoa")
public class PessoaResource  {
   
    @GET
    @Path("/search/{nome}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa getPessoa(String nome) {
       return Pessoa.findByNome(nome);
    }
   
    // desabilitando o recurso
//    @MethodProperties(exposed = false)
//    boolean delete(Long id);
}
