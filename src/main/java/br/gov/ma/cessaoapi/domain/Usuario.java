package br.gov.ma.cessaoapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Usuario extends PersistentObject<Long>{

    private static final long serialVersionUID = -83075373339767314L;

    @Column(name = "nome", columnDefinition = "varchar(200)")
    private String nome;

    @Column(name = "cpf", columnDefinition = "varchar(20)")
    private Long cpf;

    @Column(name = "senha", columnDefinition = "varchar(50)")
    private String senha;

    @Column(name = "dirigentemaximo", columnDefinition = "varchar(100)")
    private String dirigenteMaximo;

    @Column(name = "data", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(name = "validadedirigentemaximo", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate validadeDirigenteMaximo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identesexternos", referencedColumnName = "id")
    private EntesExternos entesExternos;

    public Usuario() {
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

    public EntesExternos getEntesExternos() {
        return entesExternos;
    }

    public void setEntesExternos(EntesExternos entesExternos) {
        this.entesExternos = entesExternos;
    }
}
