package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TextoDTO implements Serializable {

    private static final long serialVersionUID = -357320867407465403L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String texto;

    @ApiModelProperty(position = 3)
    private Long idTipoDocumento;

    public TextoDTO() {
    }

    public TextoDTO(Long id, String texto, Long idTipoDocumento) {
        this.id = id;
        this.texto = texto;
        this.idTipoDocumento = idTipoDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
}
