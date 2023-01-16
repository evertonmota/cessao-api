package br.gov.ma.cessaoapi.service;

import br.gov.ma.cessaoapi.dto.MunicipiosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;

import java.util.List;

public interface MunicipiosService {

    List<MunicipiosDTO> buscaMunicipioPorId(Long id) throws NotFoundException, BusinessException;
    MunicipiosDTO buscaMunicipioPorFiltros(Long id, String nome, Long idEstado) throws NotFoundException, BusinessException;
    MunicipiosDTO salvaMunicipio(MunicipiosDTO dto) throws NotFoundException, BusinessException;
    MunicipiosDTO atualizaMunicipio(MunicipiosDTO dto) throws NotFoundException, BusinessException;

}
