package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class EntesExternosDTO implements Serializable {

    private static final long serialVersionUID = -5666392519517395722L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String nomeEnteExterno;

    @ApiModelProperty(position = 3)
    private Long idPais;

    @ApiModelProperty(position = 4)
    private Long idEstado;

    @ApiModelProperty(position = 5)
    private Long idMunicipio;

    public EntesExternosDTO() {
    }

    public EntesExternosDTO(Long id, String nomeEnteExterno, Long idPais, Long idEstado, Long idMunicipio) {
        this.id = id;
        this.nomeEnteExterno = nomeEnteExterno;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEnteExterno() {
        return nomeEnteExterno;
    }

    public void setNomeEnteExterno(String nomeEnteExterno) {
        this.nomeEnteExterno = nomeEnteExterno;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
