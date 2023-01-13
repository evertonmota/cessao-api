package br.gov.ma.cessaoapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cargos", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Cargos extends PersistentObject<Long>{

    private static final long serialVersionUID = -6352093457407034045L;

    @Column(name = "nomecargo", columnDefinition = "varchar(200)")
    private String nomeCargo;

    @Column(name = "simbologiacargo", columnDefinition = "varchar(50)")
    private String simbologiaCargo;

    @Column(name = "valorcargo", columnDefinition = "NUMERIC(12, 2)")
    private BigDecimal valorCargo;

    @Column(name = "cargahoraria", columnDefinition = "INTEGER")
    private Integer cargaHoraria;

    @Column(name = "externo", columnDefinition = "BOOLEAN")
    private boolean externo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identesexternos", referencedColumnName = "id")
    private EntesExternos entesExternos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargoexternos", referencedColumnName = "id")
    private Cargos cargoExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestadoexternos", referencedColumnName = "id")
    private Cargos cargoEstado;

    public Cargos() {
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getSimbologiaCargo() {
        return simbologiaCargo;
    }

    public void setSimbologiaCargo(String simbologiaCargo) {
        this.simbologiaCargo = simbologiaCargo;
    }

    public BigDecimal getValorCargo() {
        return valorCargo;
    }

    public void setValorCargo(BigDecimal valorCargp) {
        this.valorCargo = valorCargp;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    public EntesExternos getEntesExternos() {
        return entesExternos;
    }

    public void setEntesExternos(EntesExternos entesExternos) {
        this.entesExternos = entesExternos;
    }

    public Cargos getCargoExterno() {
        return cargoExterno;
    }

    public void setCargoExterno(Cargos cargoExterno) {
        this.cargoExterno = cargoExterno;
    }

    public Cargos getCargoEstado() {
        return cargoEstado;
    }

    public void setCargoEstado(Cargos cargoEstado) {
        this.cargoEstado = cargoEstado;
    }
}
