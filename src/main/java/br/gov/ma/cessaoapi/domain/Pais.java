package br.gov.ma.cessaoapi.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pais {

    @Id
    @GeneratedValue()
    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2 ,  max = 100, message = "O tamanho deve ser entre 10 e até 100 digitos")
    private String nomePais;

    public Pais() {
    }

    public Pais(Long id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
