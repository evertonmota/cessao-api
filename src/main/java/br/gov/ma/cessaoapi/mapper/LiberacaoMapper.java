package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Liberacao;
import br.gov.ma.cessaoapi.dto.LiberacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {UsuarioMapper.class, CessaoServidoresMapper.class})
public interface LiberacaoMapper extends EntityMapper<LiberacaoDTO, Liberacao> {

    @Mapping(source = "idUsuario", target = "usuario.id")
    @Mapping(source = "idCessaoServidor", target = "cessaoServidor.id")
    Liberacao toEntity (LiberacaoDTO liberacaoDTO);

    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "cessaoServidor.id", target = "idCessaoServidor")
    LiberacaoDTO toDto(Liberacao liberacao);

    default Liberacao fromId(Long id) {
        if (id == null) {
            return null;
        }

        Liberacao liberacao = new Liberacao();
        liberacao.setId(id);
        return liberacao;
    }
}
