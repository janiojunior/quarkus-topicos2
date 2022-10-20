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

import br.unitins.dto.CidadeDTO;
import br.unitins.dto.CidadeResponseDTO;
import br.unitins.model.Cidade;
import br.unitins.repository.CidadeRepository;
import br.unitins.repository.EstadoRepository;

@Path("/cidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CidadeResource {
    
    @Inject
    private CidadeRepository repository;

    @GET
    public List<CidadeResponseDTO> getAll(){
        return repository.findAllCidades();
    }

    @GET
    @Path("/search/{nome}")
    public List<CidadeResponseDTO> getListCidade(String nome){
        return repository.findByNome(nome);
    }

    @GET
    @Path("/{id}")
    public CidadeResponseDTO get(Long id) {
        return new CidadeResponseDTO(repository.findById(id));
    }

    @POST
    @Transactional
    public Response create(CidadeDTO dto) { 
       EstadoRepository rEstado = new EstadoRepository();

        Cidade entity = new Cidade();
        entity.nome = dto.getNome();
        entity.estado = rEstado.findById(dto.getIdEstado());

        repository.persist(entity);
        CidadeResponseDTO retorno = new CidadeResponseDTO(entity);

        return Response.created(URI.create("/cidades/" +entity.id)).entity(retorno).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public CidadeResponseDTO update(Long id, CidadeDTO dto) {
        EstadoRepository rEstado = new EstadoRepository();
        Cidade entity = repository.findById(id);
        if(entity == null)
            throw new NotFoundException();

        entity.nome = dto.getNome();
        entity.estado = rEstado.findById(dto.getIdEstado());

        return new CidadeResponseDTO(entity);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        Cidade entity = repository.findById(id);
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
