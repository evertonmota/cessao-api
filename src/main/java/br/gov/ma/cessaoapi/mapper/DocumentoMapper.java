package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Documentos;
import br.gov.ma.cessaoapi.dto.DocumentosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {CessaoServidoresMapper.class, TextoMapper.class})
public interface DocumentoMapper extends EntityMapper<DocumentosDTO, Documentos> {

    @Mapping(source = "idCessaoServidor", target = "cessaoServidor.id")
    @Mapping(source = "idTexto", target = "texto.id")
    Documentos toEntity (DocumentosDTO documentosDTO);

    @Mapping(source = "cessaoServidor.id", target = "idCessaoServidor")
    @Mapping(source = "texto.id", target = "idTexto")
    DocumentosDTO toDto(Documentos documentos);

    default Documentos fromId(Long id) {
        if (id == null) {
            return null;
        }

        Documentos documentos = new Documentos();
        documentos.setId(id);
        return documentos;
    }
}
