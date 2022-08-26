package br.unitins.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class Estado  extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "data_cadastro")
    public LocalDate dataCadastro;

    public String nome;
    public String sigla;
}
