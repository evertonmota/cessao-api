package br.gov.ma.cessaoapi.service.impl;

import br.gov.ma.cessaoapi.domain.Cargos;
import br.gov.ma.cessaoapi.domain.EntesExternos;
import br.gov.ma.cessaoapi.dto.CargosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.mapper.CargosMapper;
import br.gov.ma.cessaoapi.repository.CargoRepository;
import br.gov.ma.cessaoapi.repository.EntesExternosRepository;
import br.gov.ma.cessaoapi.service.CargosService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CargosServiceImpl implements CargosService {

    private final static Logger logger = LoggerFactory.getLogger(CargosServiceImpl.class);

    private final CargoRepository cargoRepository;
    private final CargosMapper cargosMapper;
    private final EntesExternosRepository entesExternosRepository;

    public CargosServiceImpl(CargoRepository cargoRepository, CargosMapper cargosMapper, EntesExternosRepository entesExternosRepository) {
        this.cargoRepository = cargoRepository;
        this.cargosMapper = cargosMapper;
        this.entesExternosRepository = entesExternosRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {BusinessException.class})
    public CargosDTO salvarCargo(CargosDTO dto) throws BusinessException {
        if(StringUtils.isEmpty(dto.getNomeCargo())){
            logger.error("O nome do cargo não pode ser nulo");
            throw new BusinessException("O nome do cargo não pode ser nulo");
        }

        Cargos cargoEstado = dto.getIdCargoEstado() == null ? null : this.cargoRepository.findById(dto.getIdCargoEstado()).orElse(null);
        Cargos cargoExterno = dto.getIdCargoEstado() == null ? null : this.cargoRepository.findById(dto.getIdCargoExterno()).orElse(null);
        EntesExternos entesExternos = dto.getIdCargoEstado() == null ? null : this.entesExternosRepository.findById(dto.getIdEntesExternos()).orElse(null);

        Cargos cargosToPersist = this.cargosMapper.toEntity(dto);
        cargosToPersist.setCargoEstado(cargoEstado);
        cargosToPersist.setCargoExterno(cargoExterno);
        cargosToPersist.setEntesExternos(entesExternos);

        this.cargoRepository.save(cargosToPersist);

        CargosDTO dtoResponse = this.cargosMapper.toDto(cargosToPersist);
        return dtoResponse;
    }

    @Override
    public List<CargosDTO> buscarTodosCargos() throws BusinessException {
        return this.cargosMapper.toDto(this.cargoRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCargo")));
    }

    @Override
    public CargosDTO buscarCargoID(Long id) throws NotFoundException, BusinessException {
        Optional<Cargos> cargosExists = this.cargoRepository.findById(id);
        if(!cargosExists.isPresent()){
            logger.error(String.format("Não foi encontrado um estado com o id [%s]", id));
            throw new NotFoundException(String.format("Não foi encontrado um estado com o id [%s]", id));
        }

        return this.cargosMapper.toDto(cargosExists.get());
    }

    @Override
    public CargosDTO atualizaCargo(Long id, CargosDTO dto) throws NotFoundException, BusinessException {
        Optional<Cargos> cargosExists = this.cargoRepository.findById(id);
        if(!cargosExists.isPresent()){
            logger.error(String.format("Não foi encontrado um estado com o id [%s]", id));
            throw new NotFoundException(String.format("Não foi encontrado um estado com o id [%s]", id));
        }

        Cargos cargoEstado = dto.getIdCargoEstado() != null ? this.cargoRepository.findById(dto.getIdCargoEstado()).orElse(null) : null;
        Cargos cargoExterno = dto.getIdCargoExterno() != null ? this.cargoRepository.findById(dto.getIdCargoExterno()).orElse(null) : null;
        EntesExternos enteExterno = dto.getIdEntesExternos() != null ? this.entesExternosRepository.findById(dto.getIdEntesExternos()).orElse(null) : null;

        cargosExists.get().setCargoEstado(cargoEstado);
        cargosExists.get().setCargoExterno(cargoExterno);
        cargosExists.get().setEntesExternos(enteExterno);
        cargosExists.get().setNomeCargo(dto.getNomeCargo());
        cargosExists.get().setValorCargo(dto.getValorCargo());
        cargosExists.get().setSimbologiaCargo(dto.getSimbologiaCargo());
        cargosExists.get().setCargaHoraria(dto.getCargaHoraria());
        cargosExists.get().setExterno(dto.getExterno());

        this.cargoRepository.save(cargosExists.get());
        return this.cargosMapper.toDto(cargosExists.get());
    }

    @Override
    public List<CargosDTO> buscarCargoEnteExterno(Long idEnteExterno) throws BusinessException {
        return this.cargosMapper.toDto(this.cargoRepository.findAllByEntesExternosIdOrderByNomeCargo(idEnteExterno));
    }
}
