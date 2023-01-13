package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.CessaoServidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CessaoServidorRepository extends JpaRepository<CessaoServidor, Long> {
}
