package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class LiberacaoDTO implements Serializable {

    private static final long serialVersionUID = -2147966179492681599L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String liberado;

    @ApiModelProperty(position = 3)
    private LocalDate dataMovimento;

    @ApiModelProperty(position = 4)
    private Long idUsuario;

    @ApiModelProperty(position = 5)
    private Long idCessaoServidor;

    public LiberacaoDTO() {
    }

    public LiberacaoDTO(Long id, String liberado, LocalDate dataMovimento, Long idUsuario, Long idCessaoServidor) {
        this.id = id;
        this.liberado = liberado;
        this.dataMovimento = dataMovimento;
        this.idUsuario = idUsuario;
        this.idCessaoServidor = idCessaoServidor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCessaoServidor() {
        return idCessaoServidor;
    }

    public void setIdCessaoServidor(Long idCessaoServidor) {
        this.idCessaoServidor = idCessaoServidor;
    }
}
