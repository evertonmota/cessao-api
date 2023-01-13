package br.gov.ma.cessaoapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tiposdocumentos", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class TipoDocumento extends PersistentObject<Long>{

    private static final long serialVersionUID = 5024940119534692791L;

    @Column(name = "nomedocumento", columnDefinition = "varchar(100)")
    private String nomeDocumento;

    public TipoDocumento() {
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }
}
