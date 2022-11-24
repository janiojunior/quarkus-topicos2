package br.unitins.resource;

import java.net.URI;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unitins.model.Estado;
import br.unitins.repository.EstadoRepository;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {
    
    @Inject
    private EstadoRepository repository;

    @GET
    @PermitAll
    public List<Estado> getAll(){
        return repository.listAll();
    }

    @GET
    @RolesAllowed({"Admin", "User"})
    @Path("/search/{nome}")
    public List<Estado> getListEstado(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Estado get(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @POST
    @Transactional
    public Response create(Estado estado) {
        repository.persist(estado);
        return Response.created(URI.create("/estados/" +estado.id)).entity(estado).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Estado update(@PathParam("id") Long id, Estado estado) {
        Estado entity = repository.findById(id);
        if(entity == null)
            throw new NotFoundException();
        entity.nome = estado.nome;
        entity.sigla = estado.sigla;
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Estado entity = repository.findById(id);
        if(entity == null)
            throw new NotFoundException();
        repository.delete(entity);
    }

    @GET
    @Path("/count")
    public Long count() {
        return repository.count();
    }

}
