package br.gov.ma.cessaoapi.controller;

import br.gov.ma.cessaoapi.dto.EstadosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.service.EstadosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {

    private final EstadosService estadosService;

    public EstadoController(EstadosService estadosService) {
        this.estadosService = estadosService;
    }

    @PostMapping
    @ApiOperation(value = "Salva detalhes do Estado", notes = "Método de criação das informações possíveis na entidade Estado")
    public ResponseEntity<EstadosDTO> salvarEstado(@RequestBody EstadosDTO dto) throws BusinessException {
        EstadosDTO response = this.estadosService.salvarEstado(dto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza detalhes do País", notes = "Método de Atualização das informações possíveis na entidade Estado")
    public ResponseEntity<EstadosDTO> autalizarEstado(@PathVariable("idEstado") Long idEstado, @RequestBody EstadosDTO dto) throws NotFoundException, BusinessException{
        EstadosDTO response = this.estadosService.atualizarEstado(idEstado, dto);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca detalhes do Estado por ID", notes = "Método que Busca as informações possíveis na entidade ESTADO por ID")
    public ResponseEntity<EstadosDTO> buscaEstadoPorId(Long idEstado) throws NotFoundException, BusinessException{
        EstadosDTO response = this.estadosService.buscaEstadoPorId(idEstado);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/buscar_estados_filtros/{page}/{size}")
    @ApiOperation(value = "Buscar Estados por Filtros", notes = "Método que busca as informações possíveis na entidade ESTADO por filtros")
    public ResponseEntity<List<EstadosDTO>> buscarEstadoPorFiltros(@RequestParam(value = "nomeEstado", required = false) String nomeEstado,
                                                                   @RequestParam(value = "sigla", required = false) String sigla,
                                                                   @RequestParam(value = "id", required = false) Long id,
                                                                   @RequestParam(value = "idPais", required = false) Long idPais,
                                                                   @RequestParam("page") int page, @RequestParam("size") int size) throws NotFoundException, BusinessException{
        List<EstadosDTO> response = this.estadosService.buscarEstadoPorFiltros(nomeEstado, sigla, id, idPais, page, size);
        return ResponseEntity.ok().body(response);
    }

}
