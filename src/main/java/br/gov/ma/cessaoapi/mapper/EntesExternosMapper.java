package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.EntesExternos;
import br.gov.ma.cessaoapi.dto.EntesExternosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {PaisMapper.class, EstadosMapper.class, MunicipiosMapper.class})
public interface EntesExternosMapper extends EntityMapper<EntesExternosDTO, EntesExternos> {

    @Mapping(source = "idPais", target = "pais.id")
    @Mapping(source = "idEstado", target = "estado.id")
    @Mapping(source = "idMunicipio", target = "municipio.id")
    EntesExternos toEntity (EntesExternosDTO entesExternosDTO);

    @Mapping(source = "pais.id", target = "idPais")
    @Mapping(source = "estado.id", target = "idEstado")
    @Mapping(source = "municipio.id", target = "idMunicipio")
    EntesExternosDTO toDto(EntesExternos entesExternos);

    default EntesExternos fromId(Long id) {
        if (id == null) {
            return null;
        }

        EntesExternos entesExternos = new EntesExternos();
        entesExternos.setId(id);
        return entesExternos;
    }
}
