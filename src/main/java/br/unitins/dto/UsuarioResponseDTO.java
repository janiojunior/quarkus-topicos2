package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Usuario;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private Map<String, Object> cidade;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.id;
        this.nome = usuario.nome;
        this.login = usuario.login;
        this.senha = usuario.senha;
        this.cidade = new HashMap<String, Object>();
        this.cidade.put("id", usuario.cidade.id);
        this.cidade.put("nome", usuario.cidade.nome);
        this.cidade.put("idEstado", usuario.cidade.estado.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Map<String, Object> getCidade() {
        return cidade;
    }

    public void setCidade(Map<String, Object> cidade) {
        this.cidade = cidade;
    }

   
}
