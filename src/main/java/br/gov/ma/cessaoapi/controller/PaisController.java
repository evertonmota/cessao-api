package br.gov.ma.cessaoapi.controller;

import br.gov.ma.cessaoapi.dto.PaisDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.repository.PaisRepository;
import br.gov.ma.cessaoapi.service.PaisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/paises", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaisController {

    private final PaisRepository repository ;
    private final PaisService service;

    public PaisController(PaisRepository repository, PaisService service) {
		super();
		this.repository = repository;
		this.service = service;
	}

    @PostMapping
    @ApiOperation(value = "Salva detalhes do País", notes = "Método de criação das informações possíveis na entidade PAIS")
    public ResponseEntity<PaisDTO> salvar(@RequestBody PaisDTO pais) throws BusinessException {
        PaisDTO response = this.service.salvarPais(pais);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Atualiza detalhes do País", notes = "Método de atualização das informações possíveis na entidade PAIS")
    public ResponseEntity<PaisDTO> atualizar(@PathVariable long id, @RequestBody PaisDTO pais) throws BusinessException, NotFoundException {
        PaisDTO response = this.service.autalizarPais(id, pais);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "{id}/buscar_por_id")
    @ApiOperation(value = "Busca País por ID", notes = "Método de busca por id da entidade PAIS")
    public ResponseEntity<PaisDTO> buscaPaisPorId(@PathVariable long id) throws BusinessException, NotFoundException {
        PaisDTO response = this.service.buscaPaisPorId(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/busca_por_filtro/{page}/{size}")
    @ApiOperation(value = "Busca País por ID", notes = "Método de busca por filtros da entidade PAIS")
    public ResponseEntity<List<PaisDTO>> find(@PathVariable  String nomePais, @PathVariable int page, @PathVariable int size) throws BusinessException, NotFoundException {
        List<PaisDTO> listResponse = this.service.buscarPaisPorFiltros(nomePais, page, size);
        return ResponseEntity.ok().body(listResponse);
    }



}
