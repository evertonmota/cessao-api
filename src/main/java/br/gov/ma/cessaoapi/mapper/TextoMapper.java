package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Textos;
import br.gov.ma.cessaoapi.dto.TextoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {TipoDocumentoMapper.class})
public interface TextoMapper extends EntityMapper<TextoDTO, Textos> {

    @Mapping(source = "idTipoDocumento", target = "tipoDocumento.id")
    Textos toEntity (TextoDTO textoDTO);

    @Mapping(source = "tipoDocumento.id", target = "idTipoDocumento")
    TextoDTO toDto(Textos textos);

    default Textos fromId(Long id) {
        if (id == null) {
            return null;
        }

        Textos textos = new Textos();
        textos.setId(id);
        return textos;
    }
}
