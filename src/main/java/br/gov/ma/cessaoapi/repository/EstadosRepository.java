package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long > {
}
