package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class EstadosDTO implements Serializable {
    private static final long serialVersionUID = 6220002712550385071L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String nomeEstado;


    @ApiModelProperty(position = 3)
    private String sigla;

    @ApiModelProperty(position = 4)
    private PaisDTO pais;

    public EstadosDTO() {
    }

    public EstadosDTO(Long id, String nomeEstado, String sigla, PaisDTO pais) {
        this.id = id;
        this.nomeEstado = nomeEstado;
        this.sigla = sigla;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }
}
