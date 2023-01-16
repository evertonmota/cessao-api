package br.gov.ma.cessaoapi.controller;

import br.gov.ma.cessaoapi.dto.CargosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.service.CargosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/cargos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CargosController {

    private final CargosService cargosService;

    public CargosController(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    @PostMapping
    @ApiOperation(value = "Salva detalhes do cargo", notes = "Método de criação das informações na entidade CARGO")
    public ResponseEntity<CargosDTO> salvarCargo(@RequestBody CargosDTO dto) throws BusinessException{
        CargosDTO response = this.cargosService.salvarCargo(dto);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @ApiOperation(value = "Busca todos os cargos", notes = "Método que busca todos os dados da entidade CARGO sem filtros")
    public ResponseEntity<List<CargosDTO>> buscarTodosCargos() throws BusinessException {
        List<CargosDTO> response = this.cargosService.buscarTodosCargos();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca cargo por ID", notes = "Método que busca todos os dados da entidade CARGO por ID")
    public ResponseEntity<CargosDTO> buscarCargoID(@PathVariable("id") Long id) throws NotFoundException, BusinessException {
        CargosDTO response = this.cargosService.buscarCargoID(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Atualiza informacoes do Cargo", notes = "Método que atualiza todos os dados da entidade CARGO")
    public ResponseEntity<CargosDTO> atualizaCargo(@PathVariable("id") Long id, @RequestBody CargosDTO dto) throws NotFoundException, BusinessException {
        CargosDTO response = this.cargosService.atualizaCargo(id, dto);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/ente_externo/{idEnteExterno}")
    @ApiOperation(value = "Busca cargo por Ente Externo", notes = "Método que busca todos os dados da entidade CARGO por Ente Externo ID")
    public ResponseEntity<List<CargosDTO>> buscarCargoEnteExterno(@PathVariable("idEnteExterno") Long idEnteExterno) throws BusinessException{
        List<CargosDTO> response = this.cargosService.buscarCargoEnteExterno(idEnteExterno);
        return ResponseEntity.ok().body(response);
    }
}
