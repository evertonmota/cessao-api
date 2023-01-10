package br.gov.ma.cessaoapi.service;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.repository.PaisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AllArgsConstructor
@Service
public class PaisService {

    private final PaisRepository repository ;

    public Pais salvar(Pais pais) {
        return this.repository.save(pais);
    }
}
