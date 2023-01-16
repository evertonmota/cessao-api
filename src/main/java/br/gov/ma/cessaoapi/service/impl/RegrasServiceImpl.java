package br.gov.ma.cessaoapi.service.impl;

import br.gov.ma.cessaoapi.domain.*;
import br.gov.ma.cessaoapi.dto.RegrasDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.mapper.RegrasMapper;
import br.gov.ma.cessaoapi.repository.CargoRepository;
import br.gov.ma.cessaoapi.repository.EstadosRepository;
import br.gov.ma.cessaoapi.repository.RegrasRepository;
import br.gov.ma.cessaoapi.service.RegrasService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegrasServiceImpl implements RegrasService {

    private final static Logger logger = LoggerFactory.getLogger(RegrasServiceImpl.class);

    private final RegrasRepository regrasRepository;
    private final RegrasMapper regrasMapper;
    private final CargoRepository cargoRepository;
    private final EstadosRepository estadosRepository;

    public RegrasServiceImpl(RegrasRepository regrasRepository, RegrasMapper regrasMapper, CargoRepository cargoRepository, EstadosRepository estadosRepository) {
        this.regrasRepository = regrasRepository;
        this.regrasMapper = regrasMapper;
        this.cargoRepository = cargoRepository;
        this.estadosRepository = estadosRepository;
    }

    @Override
    public RegrasDTO salvarRegras(RegrasDTO regrasDTO) throws BusinessException {
        Regras regrasToPersist = this.regrasMapper.toEntity(regrasDTO);

        Cargos cargoOrigem = regrasDTO.getIdCargoOrigem() != null ? this.cargoRepository.findById(regrasDTO.getIdCargoOrigem()).orElse(null) : null;
        Cargos cargoDestino = regrasDTO.getIdCargoDestino() != null ? this.cargoRepository.findById(regrasDTO.getIdCargoDestino()).orElse(null) : null;
        Estados estado = regrasDTO.getIdEstado() != null ? this.estadosRepository.findById(regrasDTO.getIdEstado()).orElse(null) : null;

        regrasToPersist.setCargoDestino(cargoDestino);
        regrasToPersist.setCargoOrigem(cargoOrigem);
        regrasToPersist.setEstado(estado);

        this.regrasRepository.save(regrasToPersist);
        RegrasDTO dtoResponse = this.regrasMapper.toDto(regrasToPersist);

        return dtoResponse;
    }

    @Override
    public RegrasDTO atualizaRegras(Long idRegra, RegrasDTO regrasDTO) throws NotFoundException, BusinessException {
        Optional<Regras> regrasExists = this.regrasRepository.findById(idRegra);
        if(!regrasExists.isPresent()){
            logger.error(String.format("Não foi encontrado uma regra com o id [%s]", idRegra));
            throw new NotFoundException(String.format("Não foi encontrado uma regra com o id [%s]", idRegra));
        }

        Cargos cargoOrigem = regrasDTO.getIdCargoOrigem() != null ? this.cargoRepository.findById(regrasDTO.getIdCargoOrigem()).orElse(null) : null;
        Cargos cargoDestino = regrasDTO.getIdCargoDestino() != null ? this.cargoRepository.findById(regrasDTO.getIdCargoDestino()).orElse(null) : null;
        Estados estado = regrasDTO.getIdEstado() != null ? this.estadosRepository.findById(regrasDTO.getIdEstado()).orElse(null) : null;

        regrasExists.get().setCargoOrigem(cargoOrigem == null ? regrasExists.get().getCargoOrigem() : cargoOrigem);
        regrasExists.get().setCargoDestino(cargoOrigem != null ? cargoDestino : regrasExists.get().getCargoOrigem());
        regrasExists.get().setEstado(estado != null ? estado : regrasExists.get().getEstado());
        regrasExists.get().setGrupo(regrasDTO.getGrupo());
        regrasExists.get().setDestinoLocal(regrasDTO.getDestinoLocal());
        regrasExists.get().setDecretoEstadual(regrasDTO.getDecretoEstadual());
        regrasExists.get().setDataInicioValidade(regrasDTO.getDataInicioValidade());
        regrasExists.get().setDataFimValidade(regrasDTO.getDataFimValidade());

        this.regrasRepository.save(regrasExists.get());
        return this.regrasMapper.toDto(regrasExists.get());
    }

    @Override
    public List<RegrasDTO> buscaRegrasPorFiltros(Long idOrgaoDestino, Long idOrgaoOrigem, LocalDate dataInicio,
                                                 LocalDate dataFim, int page, int size) throws NotFoundException, BusinessException {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");

        Page<Regras> response = this.filtrarListaRegras(idOrgaoDestino, idOrgaoOrigem, dataInicio, dataFim, pageable);
        return CollectionUtils.isEmpty(response.getContent()) ? null : this.regrasMapper.toDto(response.getContent());
    }

    private Page<Regras> filtrarListaRegras(Long idOrgaoDestino, Long idOrgaoOrigem, LocalDate dataInicio,
                                            LocalDate dataFim, Pageable pageable){
        Specification<Regras> specification = (root, query, cb ) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(idOrgaoDestino != null){
                predicates.add( cb.equal(root.get(Regras_.CARGO_DESTINO).get(Cargos_.ID), idOrgaoDestino ) );
            }

            if(idOrgaoOrigem != null){
                predicates.add( cb.equal(root.get(Regras_.CARGO_ORIGEM).get(Cargos_.ID), idOrgaoOrigem ) );
            }

            if(dataInicio != null){
                predicates.add( cb.equal(root.get(Regras_.DATA_INICIO_VALIDADE), dataInicio ) );
            }

            if(idOrgaoDestino != null){
                predicates.add( cb.equal(root.get(Regras_.DATA_FIM_VALIDADE), dataFim ) );
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        return this.regrasRepository.findAll(specification, pageable);
    }
}
