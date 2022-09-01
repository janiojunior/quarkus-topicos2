package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Cidade;

public class CidadeResponseDTO {

    private Long id;
    private String nome;
    private Map<String, Object> estado;

    public CidadeResponseDTO(Cidade cidade) {
        this.id = cidade.id;
        this.nome = cidade.nome;
        this.estado = new HashMap<String, Object>();
        this.estado.put("id", cidade.estado.id);
        this.estado.put("nome", cidade.estado.nome);
        this.estado.put("sigla", cidade.estado.sigla);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Object> getEstado() {
        return estado;
    }

    public void setEstado(Map<String, Object> estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
