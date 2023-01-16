package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.Usuario;
import br.gov.ma.cessaoapi.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {EntesExternosMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

    @Mapping(source = "idEntesExternos", target = "entesExternos.id")
    Usuario toEntity (UsuarioDTO usuarioDTO);

    @Mapping(source = "entesExternos.id", target = "idEntesExternos")
    UsuarioDTO toDto(Usuario usuario);

    default Usuario fromId(Long id) {
        if (id == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId(id);
        return usuario;
    }
}
