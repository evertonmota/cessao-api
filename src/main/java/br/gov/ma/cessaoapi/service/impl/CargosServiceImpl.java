package br.gov.ma.cessaoapi.service.impl;

import br.gov.ma.cessaoapi.dto.CargosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.service.CargosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CargosServiceImpl implements CargosService {

    private final static Logger logger = LoggerFactory.getLogger(CargosServiceImpl.class);

    @Override
    public CargosDTO salvarCargo(CargosDTO dto) throws BusinessException {
       return null;
    }

    @Override
    public List<CargosDTO> buscarTodosCargos() throws BusinessException {
        return null;
    }

    @Override
    public CargosDTO buscarCargoID(Long id) throws NotFoundException, BusinessException {
        return null;
    }

    @Override
    public CargosDTO atualizaCargo(Long id, CargosDTO dto) throws NotFoundException, BusinessException {
        return null;
    }
}
