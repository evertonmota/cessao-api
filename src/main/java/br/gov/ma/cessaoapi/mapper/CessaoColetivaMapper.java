package br.gov.ma.cessaoapi.mapper;

import br.gov.ma.cessaoapi.domain.CessaoColetiva;
import br.gov.ma.cessaoapi.dto.CessaoColetivaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CessaoColetivaMapper extends EntityMapper<CessaoColetivaDTO, CessaoColetiva>{

    CessaoColetiva toEntity (CessaoColetivaDTO cessaoColetivaDTO);

    CessaoColetivaDTO toDto(CessaoColetiva cessaoColetiva);

    default CessaoColetiva fromId(Long id) {
        if (id == null) {
            return null;
        }

        CessaoColetiva cessaoColetiva = new CessaoColetiva();
        cessaoColetiva.setId(id);
        return cessaoColetiva;
    }
}
