package br.gov.ma.cessaoapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "liberacao", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Liberacao extends PersistentObject<Long>{

    private static final long serialVersionUID = -5606592390209994160L;

    @Column(name = "liberado", columnDefinition = "varchar(100)")
    private String liberado;

    @Column(name = "datamovimento", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataMovimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcessaoservidor", referencedColumnName = "id")
    private CessaoServidor cessaoServidor;

    public Liberacao() {
    }

    public String getLiberado() {
        return liberado;
    }

    public void setLiberado(String liberado) {
        this.liberado = liberado;
    }

    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDate dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CessaoServidor getCessaoServidor() {
        return cessaoServidor;
    }

    public void setCessaoServidor(CessaoServidor cessaoServidor) {
        this.cessaoServidor = cessaoServidor;
    }
}
