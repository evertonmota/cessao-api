package br.gov.ma.cessaoapi.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "municipios", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Municipios extends PersistentObject<Long> {

    private static final long serialVersionUID = -855150362048834404L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 100, message = "O tamanho deve ser entre 10 e até 100 digitos")
    @Column(name = "nomemunicipio", columnDefinition = "varchar(100)")
    private String nomeMunicipio;

    @ManyToOne
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    private Estados estado;

    public Municipios() {
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
