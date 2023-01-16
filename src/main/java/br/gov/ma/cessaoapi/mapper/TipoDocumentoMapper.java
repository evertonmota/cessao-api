package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.TipoDocumento;
import br.gov.ma.cessaoapi.dto.TipoDocumentoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper extends EntityMapper<TipoDocumentoDTO, TipoDocumento> {

    TipoDocumento toEntity (TipoDocumentoDTO tipoDocumentoDTO);

    TipoDocumentoDTO toDto(TipoDocumento tipoDocumento);

    default TipoDocumento fromId(Long id) {
        if (id == null) {
            return null;
        }

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(id);
        return tipoDocumento;
    }
}
