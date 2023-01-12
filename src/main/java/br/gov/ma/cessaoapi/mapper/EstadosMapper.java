package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Estados;
import br.gov.ma.cessaoapi.dto.EstadosDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadosMapper extends EntityMapper<EstadosDTO, Estados>{

    Estados toEntity(EstadosDTO estadosDTO);

    EstadosDTO toDto(Estados estados);

    default Estados fromId(Long id) {
        if (id == null) {
            return null;
        }

        Estados estados = new Estados();
        estados.setId(id);
        return estados;
    }
}
