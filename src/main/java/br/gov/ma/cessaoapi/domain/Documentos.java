package br.gov.ma.cessaoapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "documentos", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Documentos extends PersistentObject<Long>{

    private static final long serialVersionUID = -2053332185441470065L;

    @Column(name = "enderecovirtual", columnDefinition = "varchar(300)")
    private String enderecovirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcssaoservidor", referencedColumnName = "id")
    private CessaoServidor cessaoServidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtexto", referencedColumnName = "id")
    private Textos texto;

    public Documentos() {
    }

    public String getEnderecovirtual() {
        return enderecovirtual;
    }

    public void setEnderecovirtual(String enderecovirtual) {
        this.enderecovirtual = enderecovirtual;
    }

    public CessaoServidor getCessaoServidor() {
        return cessaoServidor;
    }

    public void setCessaoServidor(CessaoServidor cessaoServidor) {
        this.cessaoServidor = cessaoServidor;
    }

    public Textos getTexto() {
        return texto;
    }

    public void setTexto(Textos texto) {
        this.texto = texto;
    }
}
