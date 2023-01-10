package br.gov.ma.cessaoapi.service;

import org.springframework.stereotype.Service;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.repository.PaisRepository;

@Service
public class PaisService {

    private final PaisRepository repository ;
    
    public PaisService(PaisRepository repository) {
		super();
		this.repository = repository;
	}



	public Pais salvar(Pais pais) {
        return this.repository.save(pais);
    }
}
