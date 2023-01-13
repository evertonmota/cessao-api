package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 4467025039693233579L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String nomePais;

    public PaisDTO() {
    }

    public PaisDTO(Long id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
