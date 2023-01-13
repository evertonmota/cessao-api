package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Municipios;
import br.gov.ma.cessaoapi.dto.MunicipiosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {EstadosMapper.class})
public interface MunicipiosMapper extends EntityMapper<MunicipiosDTO, Municipios> {

    @Mapping(source = "idEstado", target = "estado.id")
    Municipios toEntity (MunicipiosDTO municipiosDTO);

    @Mapping(source = "estado.id", target = "idEstado")
    MunicipiosDTO toDto(Municipios municipios);

    default Municipios fromId(Long id) {
        if (id == null) {
            return null;
        }

        Municipios municipios = new Municipios();
        municipios.setId(id);
        return municipios;
    }
}
