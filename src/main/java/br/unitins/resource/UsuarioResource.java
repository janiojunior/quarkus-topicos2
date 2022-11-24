package br.unitins.resource;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
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
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.form.UsuarioForm;
import br.unitins.model.Usuario;
import br.unitins.repository.UsuarioRepository;
import br.unitins.service.FileService;
import br.unitins.repository.CidadeRepository;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    private UsuarioRepository repository;

    @Inject
    private FileService fileService;

    // @GET
    // public List<UsuarioResponseDTO> getAll(){
    //     return repository.findAllUsuarios();
    // }

    @GET
    public List<Usuario> getAll(){
        return repository.findAllUsuarios2();
    }

    @GET
    @Path("/search/{nome}")
    public List<UsuarioResponseDTO> getListUsuario(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

    @GET
    @Path("/{id}")
    public UsuarioResponseDTO get(@PathParam("id") Long id) {
        return new UsuarioResponseDTO(repository.findById(id));
    }

    @POST
    @Transactional
    public Response create(UsuarioDTO dto) { 
       CidadeRepository rCidade = new CidadeRepository();

        Usuario entity = new Usuario();
        entity.nome = dto.getNome();
        entity.login = dto.getLogin();
        entity.senha = dto.getSenha();
        entity.cidade = rCidade.findById(dto.getIdCidade());

        repository.persist(entity);
        
        return Response.created(URI.create("/usuarios/" +entity.id)).entity(new UsuarioResponseDTO(entity)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public UsuarioResponseDTO update(@PathParam("id") Long id, UsuarioDTO dto) {
        CidadeRepository rCidade = new CidadeRepository();
        Usuario entity = repository.findById(id);
        if(entity == null)
            throw new NotFoundException();

        entity.nome = dto.getNome();
        entity.login = dto.getLogin();
        entity.senha = dto.getSenha();
        entity.cidade = rCidade.findById(dto.getIdCidade());

        return new UsuarioResponseDTO(entity);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Usuario entity = repository.findById(id);
        if(entity == null)
            throw new NotFoundException();
        repository.delete(entity);
    }

    @GET
    @Path("/count")
    public Long count() {
        return repository.count();
    }


    @POST
    @Path("/postupload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response createComUpload(@MultipartForm UsuarioForm form) { 
        String nomeImagem = "";
        try {
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNomeImagem());
        } catch (IOException e) {
            Response.ok(e.getMessage(), MediaType.TEXT_PLAIN).status(422).build();
            e.printStackTrace();
        }

       CidadeRepository rCidade = new CidadeRepository();

        Usuario entity = new Usuario();
        entity.nome = form.getNome();
        entity.login = form.getLogin();
        entity.senha = form.getSenha();
        entity.nomeImagem = nomeImagem;
        entity.cidade = rCidade.findById(form.getIdCidade());

        repository.persist(entity);
        
        return Response.created(URI.create("/usuarios/" +entity.id)).entity(new UsuarioResponseDTO(entity)).build();
    }

    @GET
    @Path("/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadImage(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", 
            "attachment;filename="+nomeImagem);
        return response.build();
    }
}
