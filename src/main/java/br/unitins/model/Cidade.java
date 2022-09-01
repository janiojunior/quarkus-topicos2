package br.unitins.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends DefaultEntity {
  
    public String nome; 

    @ManyToOne
    @JoinColumn(name = "id_estado")
    public Estado estado;
}
