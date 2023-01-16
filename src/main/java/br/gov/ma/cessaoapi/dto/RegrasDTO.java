package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class RegrasDTO implements Serializable {

    private static final long serialVersionUID = 1311240419154940203L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    @NotNull(message = "Campo Grupo é obrigatório")
    private Integer grupo;

    @ApiModelProperty(position = 3)
    private String destinoLocal;

    @ApiModelProperty(position = 4)
    private String decretoEstadual;

    @ApiModelProperty(position = 5)
    private LocalDate dataInicioValidade;

    @ApiModelProperty(position = 6)
    private LocalDate dataFimValidade;

    @ApiModelProperty(position = 7)
    private Long idCargoDestino;

    @ApiModelProperty(position = 8)
    private Long idCargoOrigem;

    @ApiModelProperty(position = 9)
    private Long idEstado;

    public RegrasDTO() {
    }

    public RegrasDTO(Long id, Integer grupo, String destinoLocal, String decretoEstadual, LocalDate dataInicioValidade,
                     LocalDate dataFimValidade, Long idCargoDestino, Long idCargoOrigem, Long idEstado) {
        this.id = id;
        this.grupo = grupo;
        this.destinoLocal = destinoLocal;
        this.decretoEstadual = decretoEstadual;
        this.dataInicioValidade = dataInicioValidade;
        this.dataFimValidade = dataFimValidade;
        this.idCargoDestino = idCargoDestino;
        this.idCargoOrigem = idCargoOrigem;
        this.idEstado = idEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
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

    public Long getIdCargoDestino() {
        return idCargoDestino;
    }

    public void setIdCargoDestino(Long idCargoDestino) {
        this.idCargoDestino = idCargoDestino;
    }

    public Long getIdCargoOrigem() {
        return idCargoOrigem;
    }

    public void setIdCargoOrigem(Long idCargoOrigem) {
        this.idCargoOrigem = idCargoOrigem;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
