package br.gov.ma.cessaoapi.service;

import br.gov.ma.cessaoapi.dto.EstadosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;

import java.io.Serializable;
import java.util.List;

public interface EstadosService extends Serializable {

    EstadosDTO salvarEstado(EstadosDTO dto) throws BusinessException;
    EstadosDTO autalizarEstado(Long idEstado, EstadosDTO dto) throws NotFoundException, BusinessException;
    EstadosDTO buscaEstadoPorId(Long idEstado) throws NotFoundException, BusinessException;
    List<EstadosDTO> buscarEstadoPorFiltros(String nomeEstado, int page, int size) throws NotFoundException, BusinessException;
}
