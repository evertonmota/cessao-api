package br.gov.ma.cessaoapi.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "municipios", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Municipios extends PersistentObject<Long>{
    private static final long serialVersionUID = 1149627233336062499L;


    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 100, message = "O tamanho deve ser até 100 digitos")
    @Column(name = "nome", columnDefinition = "varchar(100)")
    private String nomeMunicipio;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estados estados;

    public Municipios() {
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }
}
