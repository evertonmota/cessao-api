package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.dto.PaisDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends EntityMapper<PaisDTO, Pais> {

    default Pais fromId(Long id) {
        if (id == null) {
            return null;
        }

        Pais pais = new Pais();
        pais.setId(id);
        return pais;
    }
}
