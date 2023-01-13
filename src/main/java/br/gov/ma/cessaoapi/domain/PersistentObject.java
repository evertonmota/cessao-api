package br.gov.ma.cessaoapi.domain;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public class PersistentObject<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 3047283200364278876L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    protected ID id;

    /*@Size(max = 200)
    @Column(name = "createdby", columnDefinition = "varchar(100)")
    protected String createdby;

    @Column(name = "created", columnDefinition = "timestamp")
    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    protected LocalDateTime created;

    @Size(max = 200)
    @Column(name = "alteredby", columnDefinition = "varchar(100)")
    protected String alteredby;

    @Column(name = "altered", columnDefinition = "timestamp")
    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    protected LocalDateTime altered;*/

    public PersistentObject() {
    }

    /*public PersistentObject(String createdby, LocalDateTime created) {
        this.createdby = createdby;
        this.created = created;
    }*/

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    /*public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = StringUtils.isEmpty(createdby) ? createdby : createdby.toUpperCase();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getAlteredby() {
        return alteredby;
    }

    public void setAlteredby(String alteredby) {
        this.alteredby = StringUtils.isEmpty(alteredby) ? alteredby : alteredby.toUpperCase();
    }

    public LocalDateTime getAltered() {
        return altered;
    }

    public void setAltered(LocalDateTime altered) {
        this.altered = altered;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersistentObject<?> that = (PersistentObject<?>) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
