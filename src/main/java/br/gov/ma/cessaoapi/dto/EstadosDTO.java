package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class EstadosDTO implements Serializable {

    private static final long serialVersionUID = 6220002712550385071L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)

    @NotNull(message = "Nome do Estado é obrigatório")
    private String nome;

    @ApiModelProperty(position = 3)
    @NotEmpty(message = "Preenchimento obrigatório")
    private String sigla;

    @ApiModelProperty(position = 4)
    private Long idPais;

    public EstadosDTO() {
    }

    public EstadosDTO(Long id, String nome, String sigla, Long idPais) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.idPais = idPais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

<<<<<<< HEAD
    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
=======
    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
>>>>>>> 5cff2f755bc92cab95d230d659cd4df4165610cd
    }
}
