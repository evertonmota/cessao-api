package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -9098565271391625051L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "Nome Municipio é obrigatório")
    private String nome;

    @ApiModelProperty(position = 2)
    private Long cpf;

    @ApiModelProperty(position = 3)
    private String senha;

    @ApiModelProperty(position = 4)
    private String dirigenteMaximo;

    @ApiModelProperty(position = 5)
    private LocalDate data;

    @ApiModelProperty(position = 6)
    private LocalDate validadeDirigenteMaximo;

    @ApiModelProperty(position = 7)
    private Long idEntesExternos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nome, Long cpf, String senha, String dirigenteMaximo, LocalDate data, LocalDate validadeDirigenteMaximo, Long idEntesExternos) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.dirigenteMaximo = dirigenteMaximo;
        this.data = data;
        this.validadeDirigenteMaximo = validadeDirigenteMaximo;
        this.idEntesExternos = idEntesExternos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDirigenteMaximo() {
        return dirigenteMaximo;
    }

    public void setDirigenteMaximo(String dirigenteMaximo) {
        this.dirigenteMaximo = dirigenteMaximo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getValidadeDirigenteMaximo() {
        return validadeDirigenteMaximo;
    }

    public void setValidadeDirigenteMaximo(LocalDate validadeDirigenteMaximo) {
        this.validadeDirigenteMaximo = validadeDirigenteMaximo;
    }

    public Long getIdEntesExternos() {
        return idEntesExternos;
    }

    public void setIdEntesExternos(Long idEntesExternos) {
        this.idEntesExternos = idEntesExternos;
    }
}
