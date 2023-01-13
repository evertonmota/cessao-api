package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class CargosDTO implements Serializable {

    private static final long serialVersionUID = -8790843319969026960L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    @NotNull(message = "Nome do Cargo não pode ser nulo")
    private String nomeCargo;

    @ApiModelProperty(position = 3)
    @NotNull(message = "Simbologia não pode ser nulo")
    private String simbologiaCargo;

    @ApiModelProperty(position = 4)
    @NotNull(message = "Valor do Cargo não pode ser nulo")
    private BigDecimal valorCargo;

    @ApiModelProperty(position = 5)
    @NotNull(message = "Carga horaria do cargo não pode ser nulo")
    private Integer cargaHoraria;

    @ApiModelProperty(position = 6)
    @NotNull(message = "Campo externo não pode ser nulo")
    private String externo;

    @ApiModelProperty(position = 7)
    private Long idEntesExternos;

    @ApiModelProperty(position = 8)
    private Long idCargoExterno;

    @ApiModelProperty(position = 9)
    private Long idCargoEstado;

    public CargosDTO() {
    }

    public CargosDTO(Long id, String nomeCargo, String simbologiaCargo, BigDecimal valorCargo, Integer cargaHoraria,
                     String externo, Long idEntesExternos, Long idCargoExterno, Long idCargoEstado) {
        this.id = id;
        this.nomeCargo = nomeCargo;
        this.simbologiaCargo = simbologiaCargo;
        this.valorCargo = valorCargo;
        this.cargaHoraria = cargaHoraria;
        this.externo = externo;
        this.idEntesExternos = idEntesExternos;
        this.idCargoExterno = idCargoExterno;
        this.idCargoEstado = idCargoEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setValorCargo(BigDecimal valorCargo) {
        this.valorCargo = valorCargo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }

    public Long getIdEntesExternos() {
        return idEntesExternos;
    }

    public void setIdEntesExternos(Long idEntesExternos) {
        this.idEntesExternos = idEntesExternos;
    }

    public Long getIdCargoExterno() {
        return idCargoExterno;
    }

    public void setIdCargoExterno(Long idCargoExterno) {
        this.idCargoExterno = idCargoExterno;
    }

    public Long getIdCargoEstado() {
        return idCargoEstado;
    }

    public void setIdCargoEstado(Long idCargoEstado) {
        this.idCargoEstado = idCargoEstado;
    }
}
