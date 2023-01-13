package br.gov.ma.cessaoapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "regras", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Regras extends PersistentObject<Long>{

    private static final long serialVersionUID = 4735105664114434097L;

    @Column(name = "grupo", columnDefinition = "varchar(100)")
    private Integer grupo;

    @Column(name = "destinolocal", columnDefinition = "varchar(100)")
    private String destinoLocal;

    @Column(name = "decretoestadual", columnDefinition = "varchar(100)")
    private String decretoEstadual;

    @Column(name = "datainiciovalidade", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicioValidade;

    @Column(name = "datafimvalidade", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFimValidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargodestino", referencedColumnName = "id")
    private Cargos cargoDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargoorigem", referencedColumnName = "id")
    private Cargos cargoOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    private Estados estado;

    public Regras() {
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupoc) {
        this.grupo = grupoc;
    }

    public String getDestinoLocal() {
        return destinoLocal;
    }

    public void setDestinoLocal(String destinoLocal) {
        this.destinoLocal = destinoLocal;
    }

    public String getDecretoEstadual() {
        return decretoEstadual;
    }

    public void setDecretoEstadual(String decretoEstadual) {
        this.decretoEstadual = decretoEstadual;
    }

    public LocalDate getDataInicioValidade() {
        return dataInicioValidade;
    }

    public void setDataInicioValidade(LocalDate dataInicioValidade) {
        this.dataInicioValidade = dataInicioValidade;
    }

    public LocalDate getDataFimValidade() {
        return dataFimValidade;
    }

    public void setDataFimValidade(LocalDate dataFimValidade) {
        this.dataFimValidade = dataFimValidade;
    }

    public Cargos getCargoDestino() {
        return cargoDestino;
    }

    public void setCargoDestino(Cargos cargoDestino) {
        this.cargoDestino = cargoDestino;
    }

    public Cargos getCargoOrigem() {
        return cargoOrigem;
    }

    public void setCargoOrigem(Cargos cargoOrigem) {
        this.cargoOrigem = cargoOrigem;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
