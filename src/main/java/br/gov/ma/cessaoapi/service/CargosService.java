package br.gov.ma.cessaoapi.service;

import br.gov.ma.cessaoapi.dto.CargosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;

import java.util.List;

public interface CargosService {

    CargosDTO salvarCargo(CargosDTO dto) throws BusinessException;
    List<CargosDTO> buscarTodosCargos() throws BusinessException;
    CargosDTO buscarCargoID(Long id) throws NotFoundException, BusinessException;
    CargosDTO atualizaCargo(Long id, CargosDTO dto) throws NotFoundException, BusinessException;
    List<CargosDTO> buscarCargoEnteExterno(Long idEnteExterno) throws BusinessException;
}
