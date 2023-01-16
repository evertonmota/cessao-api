package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Cargos;
import br.gov.ma.cessaoapi.dto.CargosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {EntesExternosMapper.class})
public interface CargosMapper extends EntityMapper<CargosDTO, Cargos> {
    
    @Mapping(source = "idEntesExternos", target = "entesExternos.id")
    //@Mapping(source = "idCargoExterno", target = "cargoExterno.id")
    //@Mapping(source = "idCargoEstado", target = "cargoEstado.id")
    @Mapping(target = "cargoExterno", ignore = true)
    @Mapping(target = "cargoEstado", ignore = true)
    Cargos toEntity (CargosDTO cargosDTO);

    @Mapping(source = "entesExternos.id", target = "idEntesExternos")
    @Mapping(source = "cargoExterno.id", target = "idCargoExterno")
    @Mapping(source = "cargoEstado.id", target = "idCargoEstado")
    CargosDTO toDto(Cargos cargos);

    default Cargos fromId(Long id) {
        if (id == null) {
            return null;
        }

        Cargos cargos = new Cargos();
        cargos.setId(id);
        return cargos;
    }
    
}
