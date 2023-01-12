package br.gov.ma.cessaoapi.service.impl;

import br.gov.ma.cessaoapi.domain.Estados;
import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.dto.EstadosDTO;
import br.gov.ma.cessaoapi.dto.PaisDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.mapper.EstadosMapper;
import br.gov.ma.cessaoapi.repository.EstadosRepository;
import br.gov.ma.cessaoapi.service.EstadosService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadosServiceImpl implements EstadosService {

    private static final long serialVersionUID = 3509084161182640473L;
    private final static Logger logger = LoggerFactory.getLogger(PaisServiceImpl.class);

    private final EstadosRepository repository;
    private final EstadosMapper mapper;

    public EstadosServiceImpl(EstadosRepository repository, EstadosMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {BusinessException.class})
    public EstadosDTO salvarEstado(EstadosDTO dto) throws BusinessException {
        if(StringUtils.isEmpty(dto.getNomeEstado())){
            logger.error("O nome do estado não pode ser nulo");
            throw new BusinessException("O nome do estado não pode ser nulo");
        }
        // UMA IDEIA DE COMO USAR O MAPPER, MAS CONFORME FOR EXISTINDO RELACIONAMENTO OS MAPPERS TB DEVEM CARREGAR
        Estados estadosToPersist = this.mapper.toEntity(dto);
        this.repository.save(estadosToPersist);

        EstadosDTO dtoResponse = this.mapper.toDto(estadosToPersist);
        return dtoResponse;
    }

    @Override
    public EstadosDTO autalizarEstado(Long idEstado, EstadosDTO dto) throws NotFoundException, BusinessException {
        return null;
    }

    @Override
    public EstadosDTO buscaEstadoPorId(Long idEstado) throws NotFoundException, BusinessException {
        return null;
    }

    @Override
    public List<EstadosDTO> buscarEstadoPorFiltros(String nomeEstado, int page, int size) throws NotFoundException, BusinessException {
        return null;
    }
}
