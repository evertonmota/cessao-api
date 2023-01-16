package br.gov.ma.cessaoapi.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class CessaoServidorDTO implements Serializable {

    private static final long serialVersionUID = -2625022670902130695L;

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String matriculaServidor;

    @ApiModelProperty(position = 3)
    private String tipoCessao;

    @ApiModelProperty(position = 4)
    private LocalDate dataInicioCessao;

    @ApiModelProperty(position = 5)
    private LocalDate dataFinalCessao;

    @ApiModelProperty(position = 6)
    private LocalDate prorrogacaoInicioCessao;

    @ApiModelProperty(position = 7)
    private LocalDate prorrogacaoFinalCessao;

    @ApiModelProperty(position = 8)
    private Integer prorrogacaoNumerica;

    @ApiModelProperty(position = 9)
    private String diarioOficial;

    @ApiModelProperty(position = 10)
    private String nup;

    @ApiModelProperty(position = 11)
    private Long idUsuario;

    @ApiModelProperty(position = 12)
    private Long idCargoDestino;

    @ApiModelProperty(position = 13)
    private Long idCargoOrigem;

    @ApiModelProperty(position = 14)
    private Long idCessaoColetiva;

    public CessaoServidorDTO() {
    }

    public CessaoServidorDTO(Long id, String matriculaServidor, String tipoCessao, LocalDate dataInicioCessao,
                             LocalDate dataFinalCessao, LocalDate prorrogacaoInicioCessao, LocalDate prorrogacaoFinalCessao,
                             Integer prorrogacaoNumerica, String diarioOficial, String nup, Long idUsuario,
                             Long idCargoDestino, Long idCargoOrigem, Long idCessaoColetiva) {
        this.id = id;
        this.matriculaServidor = matriculaServidor;
        this.tipoCessao = tipoCessao;
        this.dataInicioCessao = dataInicioCessao;
        this.dataFinalCessao = dataFinalCessao;
        this.prorrogacaoInicioCessao = prorrogacaoInicioCessao;
        this.prorrogacaoFinalCessao = prorrogacaoFinalCessao;
        this.prorrogacaoNumerica = prorrogacaoNumerica;
        this.diarioOficial = diarioOficial;
        this.nup = nup;
        this.idUsuario = idUsuario;
        this.idCargoDestino = idCargoDestino;
        this.idCargoOrigem = idCargoOrigem;
        this.idCessaoColetiva = idCessaoColetiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaServidor() {
        return matriculaServidor;
    }

    public void setMatriculaServidor(String matriculaServidor) {
        this.matriculaServidor = matriculaServidor;
    }

    public String getTipoCessao() {
        return tipoCessao;
    }

    public void setTipoCessao(String tipoCessao) {
        this.tipoCessao = tipoCessao;
    }

    public LocalDate getDataInicioCessao() {
        return dataInicioCessao;
    }

    public void setDataInicioCessao(LocalDate dataInicioCessao) {
        this.dataInicioCessao = dataInicioCessao;
    }

    public LocalDate getDataFinalCessao() {
        return dataFinalCessao;
    }

    public void setDataFinalCessao(LocalDate dataFinalCessao) {
        this.dataFinalCessao = dataFinalCessao;
    }

    public LocalDate getProrrogacaoInicioCessao() {
        return prorrogacaoInicioCessao;
    }

    public void setProrrogacaoInicioCessao(LocalDate prorrogacaoInicioCessao) {
        this.prorrogacaoInicioCessao = prorrogacaoInicioCessao;
    }

    public LocalDate getProrrogacaoFinalCessao() {
        return prorrogacaoFinalCessao;
    }

    public void setProrrogacaoFinalCessao(LocalDate prorrogacaoFinalCessao) {
        this.prorrogacaoFinalCessao = prorrogacaoFinalCessao;
    }

    public Integer getProrrogacaoNumerica() {
        return prorrogacaoNumerica;
    }

    public void setProrrogacaoNumerica(Integer prorrogacaoNumerica) {
        this.prorrogacaoNumerica = prorrogacaoNumerica;
    }

    public String getDiarioOficial() {
        return diarioOficial;
    }

    public void setDiarioOficial(String diarioOficial) {
        this.diarioOficial = diarioOficial;
    }

    public String getNup() {
        return nup;
    }

    public void setNup(String nup) {
        this.nup = nup;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCargoDestino() {
        return idCargoDestino;
    }

    public void setIdCargoDestino(Long idCargoDestino) {
        this.idCargoDestino = idCargoDestino;
    }

    public Long getIdCargoOrigem() {
        return idCargoOrigem;
    }

    public void setIdCargoOrigem(Long idCargoOrigem) {
        this.idCargoOrigem = idCargoOrigem;
    }

    public Long getIdCessaoColetiva() {
        return idCessaoColetiva;
    }

    public void setIdCessaoColetiva(Long idCessaoColetiva) {
        this.idCessaoColetiva = idCessaoColetiva;
    }
}
