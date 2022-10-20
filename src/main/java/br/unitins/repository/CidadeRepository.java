package br.unitins.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.dto.CidadeResponseDTO;
import br.unitins.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade>{
   
    public  List<CidadeResponseDTO> findAllCidades() {

       return listAll().stream()
        .map(cidade -> new CidadeResponseDTO(cidade))
        .collect(Collectors.toList());
    }
    public  List<CidadeResponseDTO> findByNome(String nome) {
        return find("nome LIKE ?1", "%"+nome+"%").stream()
        .map(cidade -> new CidadeResponseDTO(cidade))
        .collect(Collectors.toList());
    }
}
