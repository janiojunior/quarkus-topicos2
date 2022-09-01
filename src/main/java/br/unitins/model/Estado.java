package br.unitins.model;

import javax.persistence.Entity;

@Entity
public class Estado  extends DefaultEntity {


    public String nome;
    public String sigla;
}
