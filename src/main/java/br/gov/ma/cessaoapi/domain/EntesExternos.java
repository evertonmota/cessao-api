package br.gov.ma.cessaoapi.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entesexternos", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class EntesExternos extends PersistentObject<Long>{

    private static final long serialVersionUID = -817479639414860906L;

    @NotNull(message = "Preenchimento obrigatório")
    @Length(max = 100, message = "O tamanho não deve ultrapassar 100 digitos")
    @Column(name = "nome", columnDefinition = "varchar(100)")
    private String nomeEnteExterno;

    @OneToOne
    @JoinColumn(name = "idpais", referencedColumnName = "id", unique = false, nullable = true)
    private Pais pais;

    @OneToOne
    @JoinColumn(name = "idestado", referencedColumnName = "id", unique = false, nullable = true)
    private Estados estado;

    @OneToOne()
    @JoinColumn(name = "idmunicipio", referencedColumnName = "id", unique = false, nullable = true)
    private Municipios municipio;

    public EntesExternos() {
    }

    public String getNomeEnteExterno() {
        return nomeEnteExterno;
    }

    public void setNomeEnteExterno(String nomeEnteExterno) {
        this.nomeEnteExterno = nomeEnteExterno;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Municipios getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }
}
