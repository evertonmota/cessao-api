package br.gov.ma.cessaoapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "textos", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Textos extends PersistentObject<Long>{

    private static final long serialVersionUID = 965863549170917733L;

    @Column(name = "texto", columnDefinition = "varchar(500)")
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipodocumento", referencedColumnName = "id")
    private TipoDocumento tipoDocumento;

    public Textos() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
