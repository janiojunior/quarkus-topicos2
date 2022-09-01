package br.unitins.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@MappedSuperclass
public class DefaultEntity extends PanacheEntityBase {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "data_cadastro")
    public LocalDate dataCadastro;

    @Column(name = "data_alteracao")
    public LocalDate dataAlteracao;

    @PrePersist
    public void prePersist() {
        dataCadastro = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = LocalDate.now();
    }
}
