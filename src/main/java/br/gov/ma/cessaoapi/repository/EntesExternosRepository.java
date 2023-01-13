package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.EntesExternos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntesExternosRepository extends JpaRepository<EntesExternos, Long> {
}
