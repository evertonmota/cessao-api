package br.gov.ma.cessaoapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity
@Table(name = "cessaocoletiva", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class CessaoColetiva extends PersistentObject<Long>{

    private static final long serialVersionUID = -2584479350541502201L;

    @Column(name = "datainiciocessao", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicioCessao;

    @Column(name = "datafinalcessao", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinalCessao;

    public CessaoColetiva() {
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
}
