package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class MunicipiosDTO implements Serializable {

    private static final long serialVersionUID = 3641421714423572060L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    @NotEmpty(message = "Nome Municipio é obrigatório")
    private String nomeMunicipio;

    @ApiModelProperty(position = 3)
    private Long idEstado;

    public MunicipiosDTO() {
    }

    public MunicipiosDTO(Long id, String nomeMunicipio, Long idEstado) {
        this.id = id;
        this.nomeMunicipio = nomeMunicipio;
        this.idEstado = idEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
