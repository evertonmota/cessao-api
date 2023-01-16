package br.gov.ma.cessaoapi.controller;

import br.gov.ma.cessaoapi.dto.RegrasDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.service.RegrasService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value="/regras", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegasController {

    private final RegrasService regrasService;

    public RegasController(RegrasService regrasService) {
        this.regrasService = regrasService;
    }

    @PostMapping
    @ApiOperation(value = "Salva detalhes das Regras", notes = "Método de criação das informações possíveis na entidade Regras")
    public ResponseEntity<RegrasDTO> criarRegras(@RequestBody RegrasDTO regrasDTO) throws BusinessException {
        RegrasDTO response = this.regrasService.salvarRegras(regrasDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza detalhes das Regras", notes = "Método de Atualização das informações possíveis na entidade Regras")
    public ResponseEntity<RegrasDTO> atualizaRegras(@PathVariable Long idRegra, @RequestBody RegrasDTO regrasDTO) throws NotFoundException, BusinessException{
        RegrasDTO response = this.regrasService.salvarRegras(regrasDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/busca_regras_por_filtro/{page}/{size}")
    @ApiOperation(value = "Busca listagem de Regras por filtros", notes = "Método de listagem da entidade Regras por Filtros")
    public ResponseEntity<List<RegrasDTO>> buscaRegrasPorFiltros(@RequestParam(value = "idOrgaoDestino", required = false) Long idOrgaoDestino,
                                                                 @RequestParam(value = "idOrgaoOrigem", required = false) Long idOrgaoOrigem,
                                                                 @RequestParam(value = "dataInicio", required = false) LocalDate dataInicio,
                                                                 @RequestParam(value = "dataInicio", required = false) LocalDate dataFim,
                                                                 @PathVariable("page") int page,
                                                                 @PathVariable("size")  int size) throws  NotFoundException, BusinessException{
        List<RegrasDTO> response = this.regrasService.buscaRegrasPorFiltros(idOrgaoDestino, idOrgaoOrigem, dataInicio, dataFim, page, size);
        return ResponseEntity.ok().body(response);
    }
}
