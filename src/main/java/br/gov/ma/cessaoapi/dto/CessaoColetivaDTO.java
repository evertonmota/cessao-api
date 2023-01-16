package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class CessaoColetivaDTO implements Serializable {

    private static final long serialVersionUID = -419388039311833673L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    @NotNull(message = "Data Inicio da Cessao é obrigatório")
    private LocalDate dataInicioCessao;

    @ApiModelProperty(position = 3)
    @NotNull(message = "Data Final da Cessao é obrigatório")
    private LocalDate dataFinalCessao;

    public CessaoColetivaDTO() {
    }

    public CessaoColetivaDTO(Long id, LocalDate dataInicioCessao, LocalDate dataFinalCessao) {
        this.id = id;
        this.dataInicioCessao = dataInicioCessao;
        this.dataFinalCessao = dataFinalCessao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicioCessao() {
        return dataInicioCessao;
    }

    public void setDataInicioCessao(LocalDate dataInicioCessao) {
        this.dataInicioCessao = dataInicioCessao;
    }

    public LocalDate getDataFinalCessao() {
        return dataFinalCessao;
    }

    public void setDataFinalCessao(LocalDate dataFinalCessao) {
        this.dataFinalCessao = dataFinalCessao;
    }
}
