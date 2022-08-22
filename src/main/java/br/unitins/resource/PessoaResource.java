package br.unitins.resource;

import javax.ws.rs.Path;

import br.unitins.model.Pessoa;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;

@Path("/pessoa")
public interface PessoaResource extends PanacheEntityResource<Pessoa, Long> {
   
   
    // desabilitando o recurso
   @MethodProperties(exposed = false)
   boolean delete(Long id);
}
