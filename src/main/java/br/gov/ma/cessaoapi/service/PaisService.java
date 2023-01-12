package br.gov.ma.cessaoapi.service;

import br.gov.ma.cessaoapi.dto.PaisDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;


public interface PaisService extends Serializable {

    PaisDTO salvarPais(PaisDTO dto) throws BusinessException;
    PaisDTO autalizarPais(Long idPais, PaisDTO dto) throws NotFoundException, BusinessException;
    PaisDTO buscaPaisPorId(Long idPais) throws NotFoundException, BusinessException;
    List<PaisDTO> buscarPaisPorFiltros(String nomePais, int page, int size) throws NotFoundException, BusinessException;

}
