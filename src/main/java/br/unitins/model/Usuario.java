package br.unitins.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

    @ElementCollection
    @CollectionTable(name = "Roles", 
            joinColumns = @JoinColumn(name= "id_usuario", referencedColumnName = "id"))
    @Column(name = "role", length = 50)
    public Set<Role> roles = new HashSet<>();
}
