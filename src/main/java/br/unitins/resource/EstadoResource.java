package br.unitins.resource;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.annotations.Pos;

import br.unitins.model.Estado;
import br.unitins.repository.EstadoRepository;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {
    
    @Inject
    private EstadoRepository repository;

    @GET
    @Path("/search/{nome}")
    public List<Estado> getListEstado(String nome){
        return repository.findByNome(nome);
    }

    @GET
    @Path("/{id}")
    public Estado get(Long id) {
        return repository.findById(id);
    }

    @POST
    @Transactional
    public Response create(Estado estado) {
        repository.persist(estado);
        return Response.created(URI.create("/estados/" +estado.id)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Estado update(Long id, Estado estado) {
        Estado entity = repository.findById(id);
        if(entity == null)
            throw new NotFoundException();
        entity.nome = estado.nome;

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
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
