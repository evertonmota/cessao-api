package br.gov.ma.cessaoapi.service.impl;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.dto.PaisDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.mapper.PaisMapper;
import br.gov.ma.cessaoapi.repository.PaisRepository;
import br.gov.ma.cessaoapi.service.PaisService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * ATENÇÂO, CASO VOCES QUEIRAM FAZER REUSO DOS SERVICES, O IDEAL SERIA CRIAR UMA INTERFACE PRA ISSO E NAO DIRETAMENTE UMA CLASSE(VOU DEIXAR ESSA COMO EXEMPLO)
 * OUTRO PONTO: TODO OBJETO QUE ENTRA OU SAI DEVE SER UM DTO, NUNCA USE ENTIDADE A SERIALIZACAO PODE E VAI CAUSAR PROBLEMA.
 * VALE LEMBRAR QUE O DTO NÃO PRECISA SER IGUAL A ENTIDADE E SIM IGAUL AO OBJETO QUE PRECISE PARA POPULAR A TELA
 * */

@Service
public class PaisServiceImpl implements PaisService {

    private static final long serialVersionUID = 7453991980931748791L;
    private final static Logger logger = LoggerFactory.getLogger(PaisServiceImpl.class);

    private final PaisRepository paisRepository;
    private final PaisMapper paisMapper;

    public PaisServiceImpl(PaisRepository paisRepository, PaisMapper paisMapper) {
        this.paisRepository = paisRepository;
        this.paisMapper = paisMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {BusinessException.class})
    public PaisDTO salvarPais(PaisDTO dto) throws BusinessException {
        if(StringUtils.isEmpty(dto.getNomePais())){
            logger.error("O nome do pais não pode ser nulo");
            throw new BusinessException("O nome do pais não pode ser nulo");
        }

        // UMA IDEIA DE COMO USAR O MAPPER, MAS CONFORME FOR EXISTINDO RELACIONAMENTO OS MAPPERS TB DEVEM CARREGAR
        Pais paisToPersist = this.paisMapper.toEntity(dto);
        this.paisRepository.save(paisToPersist);

        PaisDTO dtoResponse = this.paisMapper.toDto(paisToPersist);
        return dtoResponse;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {NotFoundException.class, BusinessException.class})
    public PaisDTO autalizarPais(Long idPais, PaisDTO dto) throws NotFoundException, BusinessException {
        if(StringUtils.isEmpty(dto.getNomePais())){
            logger.error("O nome do pais não pode ser nulo");
            throw new BusinessException("O nome do pais não pode ser nulo");
        }

        Optional<Pais> paisExists = this.paisRepository.findById(idPais);
        if(!paisExists.isPresent()){
            logger.error(String.format("Não foi encontrado um pais com o id [%s]", idPais));
            throw new NotFoundException(String.format("Não foi encontrado um pais com o id [%s]", idPais));
        }

        paisExists.get().setNomePais(dto.getNomePais());
        this.paisRepository.save(paisExists.get());

        PaisDTO dtoResponse = this.paisMapper.toDto(paisExists.get());
        return dtoResponse;
    }

    @Override
    public PaisDTO buscaPaisPorId(Long idPais) throws NotFoundException, BusinessException {
        Optional<Pais> paisExists = this.paisRepository.findById(idPais);
        if(!paisExists.isPresent()){
            logger.error(String.format("Não foi encontrado um pais com o id [%s]", idPais));
            throw new NotFoundException(String.format("Não foi encontrado um pais com o id [%s]", idPais));
        }

        this.paisRepository.save(paisExists.get());

        PaisDTO dtoResponse = this.paisMapper.toDto(paisExists.get());
        return dtoResponse;
    }

    @Override
    public List<PaisDTO> buscarPaisPorFiltros(String nomePais, int page, int size) throws NotFoundException, BusinessException {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

        // TODO
        // EXISTE 3 FORMAS DE FAZER ISSO .. QUERY JPA, QUERY NATIVA OU POR SPECIFICATION. FIZ POR QUERY JPA PRA SER MAIS RAPIDO.
        // MAS ACHO SPECIFICATION MAIS ELEGANTE.
        List<PaisDTO> response = this.paisRepository.buscaPaisesPorFiltro(nomePais, pageable);
        if(CollectionUtils.isEmpty(response)){
            throw new NotFoundException("Não existe paises cadastrados");
        }
        return null;//response;
    }
}
