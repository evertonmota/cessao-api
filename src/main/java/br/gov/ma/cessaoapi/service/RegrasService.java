package br.gov.ma.cessaoapi.service;

import br.gov.ma.cessaoapi.dto.RegrasDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface RegrasService {

    RegrasDTO salvarRegras(RegrasDTO regrasDTO) throws BusinessException;
    RegrasDTO atualizaRegras(Long idRegra, RegrasDTO regrasDTO) throws NotFoundException, BusinessException;
    List<RegrasDTO> buscaRegrasPorFiltros(Long idOrgaoDestino, Long idOrgaoOrigem, LocalDate dataInicio,
                                          LocalDate dataFim, int page, int size) throws  NotFoundException, BusinessException;
}
