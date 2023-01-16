package br.gov.ma.cessaoapi.service.impl;

import br.gov.ma.cessaoapi.domain.Estados;
import br.gov.ma.cessaoapi.dto.EstadosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.mapper.EstadosMapper;
import br.gov.ma.cessaoapi.repository.EstadosRepository;
import br.gov.ma.cessaoapi.service.EstadosService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstadosServiceImpl implements EstadosService {

    private static final long serialVersionUID = 3509084161182640473L;
    private final static Logger logger = LoggerFactory.getLogger(EstadosServiceImpl.class);

    private final EstadosRepository repository;
    private final EstadosMapper mapper;

    public EstadosServiceImpl(EstadosRepository repository, EstadosMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {BusinessException.class})
    public EstadosDTO salvarEstado(EstadosDTO dto) throws BusinessException {
        if(StringUtils.isEmpty(dto.getNome())){
            logger.error("O nome do estado não pode ser nulo");
            throw new BusinessException("O nome do estado não pode ser nulo");
        }
        Estados estadosToPersist = this.mapper.toEntity(dto);
        this.repository.save(estadosToPersist);

        EstadosDTO dtoResponse = this.mapper.toDto(estadosToPersist);
        return dtoResponse;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {NotFoundException.class, BusinessException.class})
    public EstadosDTO atualizarEstado(Long idEstado, EstadosDTO dto) throws NotFoundException, BusinessException {
        if(StringUtils.isEmpty(dto.getNome())){
            logger.error("O nome do estado não pode ser nulo");
            throw new BusinessException("O nome do pais não pode ser nulo");
        }

        Optional<Estados> estadoExists = this.repository.findById(idEstado);
        if(!estadoExists.isPresent()){
            logger.error(String.format("Não foi encontrado um estado com o id [%s]", idEstado));
            throw new NotFoundException(String.format("Não foi encontrado um estado com o id [%s]", idEstado));
        }

        estadoExists.get().setNome(dto.getNome());
        this.repository.save(estadoExists.get());

        EstadosDTO dtoResponse = this.mapper.toDto(estadoExists.get());
        return dtoResponse;
    }

    @Override
    public EstadosDTO buscaEstadoPorId(Long idEstado) throws NotFoundException, BusinessException {
        Optional<Estados> estadoExists = this.repository.findById(idEstado);
        if(!estadoExists.isPresent()){
            logger.error(String.format("Não foi encontrado um estado com o id [%s]", idEstado));
            throw new NotFoundException(String.format("Não foi encontrado um estado com o id [%s]", idEstado));
        }

        return this.mapper.toDto(estadoExists.get());
    }

    @Override
    public List<EstadosDTO> buscarEstadoPorFiltros(String nomeEstado, String sigla, Long id, long idPais,
                                                   int page, int size) throws NotFoundException, BusinessException {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

        List<EstadosDTO> listResponse = this.repository.buscaEstadoPorFiltros(nomeEstado, sigla, id, idPais, pageable);
        if(CollectionUtils.isEmpty(listResponse)){
            logger.error(String.format("Não foi encontrado um resultado para a pesquisa"));
            throw new NotFoundException(String.format("Não foi encontrado um resultado para a pesquisa"));
        }

        return listResponse;
    }
}
