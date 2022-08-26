package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado>{
   
    public  List<Estado> findByNome(String nome) {
        return find("nome LIKE ?1", "%"+nome+"%").list();
    }
}
