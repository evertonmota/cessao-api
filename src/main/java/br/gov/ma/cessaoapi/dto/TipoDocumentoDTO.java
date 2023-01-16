package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TipoDocumentoDTO implements Serializable {

    private static final long serialVersionUID = -7963663229120076783L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String nomeDocumento;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(Long id, String nomeDocumento) {
        this.id = id;
        this.nomeDocumento = nomeDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }
}
