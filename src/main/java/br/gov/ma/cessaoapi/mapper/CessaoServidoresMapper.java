package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.CessaoServidor;
import br.gov.ma.cessaoapi.dto.CessaoServidorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = {CargosMapper.class, CessaoColetivaMapper.class, UsuarioMapper.class})
public interface CessaoServidoresMapper extends EntityMapper<CessaoServidorDTO, CessaoServidor> {

    @Mapping(source = "idCargoDestino", target = "cargoDestino.id")
    @Mapping(source = "idCargoOrigem", target = "cargoOrigem.id")
    @Mapping(source = "idCessaoColetiva", target = "cessaoColetiva.id")
    @Mapping(source = "idUsuario", target = "usuario.id")
    CessaoServidor toEntity (CessaoServidorDTO cessaoServidorDTO);

    @Mapping(source = "cargoDestino.id", target = "idCargoDestino")
    @Mapping(source = "cargoOrigem.id", target = "idCargoOrigem")
    @Mapping(source = "cessaoColetiva.id", target = "idCessaoColetiva")
    @Mapping(source = "usuario.id", target = "idUsuario")
    CessaoServidorDTO toDto(CessaoServidor cessaoServidor);

    default CessaoServidor fromId(Long id) {
        if (id == null) {
            return null;
        }

        CessaoServidor cessaoServidor = new CessaoServidor();
        cessaoServidor.setId(id);
        return cessaoServidor;
    }
}
