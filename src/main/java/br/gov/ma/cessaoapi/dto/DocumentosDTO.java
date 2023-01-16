package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DocumentosDTO implements Serializable {

    private static final long serialVersionUID = -4323758527735484786L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String enderecovirtual;

    @ApiModelProperty(position = 3)
    private Long idCessaoServidor;

    @ApiModelProperty(position = 4)
    private Long idTexto;

    public DocumentosDTO() {
    }

    public DocumentosDTO(Long id, String enderecovirtual, Long idCessaoServidor, Long idTexto) {
        this.id = id;
        this.enderecovirtual = enderecovirtual;
        this.idCessaoServidor = idCessaoServidor;
        this.idTexto = idTexto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnderecovirtual() {
        return enderecovirtual;
    }

    public void setEnderecovirtual(String enderecovirtual) {
        this.enderecovirtual = enderecovirtual;
    }

    public Long getIdCessaoServidor() {
        return idCessaoServidor;
    }

    public void setIdCessaoServidor(Long idCessaoServidor) {
        this.idCessaoServidor = idCessaoServidor;
    }

    public Long getIdTexto() {
        return idTexto;
    }

    public void setIdTexto(Long idTexto) {
        this.idTexto = idTexto;
    }
}
