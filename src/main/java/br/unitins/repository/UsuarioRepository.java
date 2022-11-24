package br.unitins.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
   
    public  List<UsuarioResponseDTO> findAllUsuarios() {
       return listAll().stream()
        .map(usuario -> new UsuarioResponseDTO(usuario))
        .collect(Collectors.toList());
    }

    public  List<Usuario> findAllUsuarios2() {
        return listAll();
     }

    public  List<UsuarioResponseDTO> findByNome(String nome) {
        return find("nome LIKE ?1", "%"+nome+"%").stream()
        .map(usuario -> new UsuarioResponseDTO(usuario))
        .collect(Collectors.toList());
    }

    public  Usuario findByLoginAndSenha(String login, String senha) {
        return find("login = ?1 AND senha = ?2", login, senha).singleResult();
    }
}
