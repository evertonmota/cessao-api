package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Regras;
import br.gov.ma.cessaoapi.dto.RegrasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {CargosMapper.class, EstadosMapper.class})
public interface RegrasMapper extends EntityMapper<RegrasDTO, Regras> {

    @Mapping(target = "cargoDestino", ignore = true)
    @Mapping(target = "cargoOrigem", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Regras toEntity (RegrasDTO regrasDTO);

    @Mapping(source = "cargoDestino.id", target = "idCargoDestino")
    @Mapping(source = "cargoOrigem.id", target = "idCargoOrigem")
    @Mapping(source = "estado.id", target = "idEstado")
    RegrasDTO toDto(Regras regras);

    default Regras fromId(Long id) {
        if (id == null) {
            return null;
        }

        Regras regras = new Regras();
        regras.setId(id);
        return regras;
    }
}
