package br.gov.ma.cessaoapi.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.repository.PaisRepository;
import br.gov.ma.cessaoapi.service.PaisService;


@RestController
@RequestMapping(value="/paises")
public class PaisController {

    private PaisRepository repository ;
    private PaisService service;
    private ModelMapper modelMapper;

    public PaisController(PaisRepository repository, PaisService service, ModelMapper modelMapper) {
		super();
		this.repository = repository;
		this.service = service;
		this.modelMapper = modelMapper;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(PaisController.class);

   @PostMapping
    public ResponseEntity<Pais> salvar(@RequestBody Pais pais){
        return ResponseEntity.ok(service.salvar(pais));
    }


    /*@PostMapping
    public ResponseEntity<PaisResponse> salvar(@RequestBody PaisRequest request){
    	Pais pais = mapper.toPais(request);
    	Pais paisSalvo = service.salvar(pais);
    	PaisResponse paisResponse = mapper.toPaisResponse(paisSalvo);
    	return ResponseEntity.status(HttpStatus.OK).body(paisResponse);
    }*/


//    @GetMapping
//    public List<PaisModel>listarTodos(){
//        return repository.findAll()
//                .stream()
//                .map(this::toPaisModel)
//                .collect(Collectors.toList());
//    }

//    @GetMapping("/paisId")
//    public PaisModel buscar(@PathVariable UUID paisID){
//        Pais pais = repository.findById(paisID)
//                .orElseThrow(PaisNaoEncontradoException:: new);
//
//        return toPaisModel(pais);
//    }

    /*private PaisModel toPaisModel (Pais pais){
        return modelMapper.map(pais,PaisModel.class);
    }*/

}
