package br.gov.ma.cessaoapi.dto;

import br.gov.ma.cessaoapi.domain.EntesExternos;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioDTO implements Serializable {

    @ApiModelProperty(position = 1)
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
    private EntesExternos entesExternos;


}
