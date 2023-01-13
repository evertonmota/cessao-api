package br.gov.ma.cessaoapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cessaoservidor", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class CessaoServidor extends PersistentObject<Long>{

    private static final long serialVersionUID = -2657157108487169667L;

    @Column(name = "matriculaservidor", columnDefinition = "varchar(100)")
    private String matriculaServidor;

    @Column(name = "tipocessao", columnDefinition = "varchar(100)")
    private String tipoCessao;

    @Column(name = "datainiciocessao", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicioCessao;

    @Column(name = "datafinalcessao", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinalCessao;

    @Column(name = "prorrogacaoiniciocessao", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate prorrogacaoInicioCessao;

    @Column(name = "prorrogacaofinalcessao", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate prorrogacaoFinalCessao;

    @Column(name = "prorrogacaonumerica", columnDefinition = "INTEGER")
    private Integer prorrogacaoNumerica;

    @Column(name = "diariooficial", columnDefinition = "varchar(250)")
    private String diarioOficial;

    @Column(name = "nup", columnDefinition = "varchar(100)")
    private String nup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargodestino", referencedColumnName = "id")
    private Cargos cargoDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargoorigem", referencedColumnName = "id")
    private Cargos cargoOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcessaocoletiva", referencedColumnName = "id")
    private CessaoColetiva cessaoColetiva;

    public CessaoServidor() {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cargos getCargoDestino() {
        return cargoDestino;
    }

    public void setCargoDestino(Cargos cargoDestino) {
        this.cargoDestino = cargoDestino;
    }

    public Cargos getCargoOrigem() {
        return cargoOrigem;
    }

    public void setCargoOrigem(Cargos cargoOrigem) {
        this.cargoOrigem = cargoOrigem;
    }

    public CessaoColetiva getCessaoColetiva() {
        return cessaoColetiva;
    }

    public void setCessaoColetiva(CessaoColetiva cessaoColetiva) {
        this.cessaoColetiva = cessaoColetiva;
    }
}
