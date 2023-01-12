package br.gov.ma.cessaoapi.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "estados", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Estados extends PersistentObject<Long> {

    private static final long serialVersionUID = 7252861410635979601L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 100, message = "O tamanho deve ser até 100 digitos")
    @Column(name = "nome", columnDefinition = "varchar(100)")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 2, message = "O tamanho deve ser até 100 digitos")
    @Column(name = "sigla", columnDefinition = "varchar(2)")
    private String sigla;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;

    public Estados() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
