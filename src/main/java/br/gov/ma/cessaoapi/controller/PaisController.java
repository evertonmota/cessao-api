package br.gov.ma.cessaoapi.controller;

import api.mapper.PaisMapper;
import api.request.PaisRequest;
import api.response.PaisResponse;
import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.model.PaisModel;
import br.gov.ma.cessaoapi.repository.PaisRepository;
import br.gov.ma.cessaoapi.service.PaisService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@RestController
@RequestMapping(value="/paises")
public class PaisController {

    private PaisRepository repository ;
    
    private final PaisService service ;
    private final PaisMapper mapper ;

    private ModelMapper modelMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaisController.class);

  /* @PostMapping
    public ResponseEntity<Pais> salvar(@RequestBody Pais pais){
        return ResponseEntity.ok(service.salvar(pais));
    }
*/

    @PostMapping
    public ResponseEntity<PaisResponse> salvar(@RequestBody PaisRequest request){
    	Pais pais = mapper.toPais(request);
    	Pais paisSalvo = service.salvar(pais);
    	PaisResponse paisResponse = mapper.toPaisResponse(paisSalvo);
    	return ResponseEntity.status(HttpStatus.OK).body(paisResponse);
    }


    @GetMapping
    public List<PaisModel>listarTodos(){
        return repository.findAll()
                .stream()
                .map(this::toPaisModel)
                .collect(Collectors.toList());
    }

//    @GetMapping("/paisId")
//    public PaisModel buscar(@PathVariable UUID paisID){
//        Pais pais = repository.findById(paisID)
//                .orElseThrow(PaisNaoEncontradoException:: new);
//
//        return toPaisModel(pais);
//    }

    private PaisModel toPaisModel (Pais pais){
        return modelMapper.map(pais,PaisModel.class);
    }

}
