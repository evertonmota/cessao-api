package br.gov.ma.cessaoapi.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pais", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Pais extends PersistentObject<Long> {

    private static final long serialVersionUID = 6103281258333811621L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2 ,  max = 100, message = "O tamanho deve ser entre 10 e até 100 digitos")
    @Column(name = "nomepais", columnDefinition = "varchar(200)")
    private String nomePais;

    public Pais() {
    }

    public Pais(Long id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
