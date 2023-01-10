package api.mapper;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.dto.PaisDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaisMapperInterface extends EntityMapper<PaisDTO, Pais>{

    @Mapping(source="id", target="id")
    @Mapping(source="nomePais", target="nomePais")
    Pais toEntity(PaisDTO paisDTO);

    @Mapping(source="id", target="id")
    @Mapping(source="nomePais", target="nomePais")
    PaisDTO toDto(Pais pais);

    default Pais fromId(Long id){
        if(id == null){
            return null;
        }
        Pais pais = new Pais();
        pais.setId(id);
        return pais;
    }



}
