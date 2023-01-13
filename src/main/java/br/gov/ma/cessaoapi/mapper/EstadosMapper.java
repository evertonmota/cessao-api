package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Estados;
import br.gov.ma.cessaoapi.dto.EstadosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {PaisMapper.class})
public interface EstadosMapper extends EntityMapper<EstadosDTO, Estados> {

    @Mapping(source = "idPais", target = "pais.id")
    Estados toEntity (EstadosDTO estadosDTO);

    @Mapping(source = "pais.id", target = "idPais")
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
