package br.unitins.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario extends DefaultEntity {
  
    public String nome; 
    public String login;
    public String senha;
    public String nomeImagem;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    public Cidade cidade;
}
