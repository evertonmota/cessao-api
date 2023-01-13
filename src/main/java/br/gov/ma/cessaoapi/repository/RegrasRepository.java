package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Regras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegrasRepository extends JpaRepository<Regras, Long> {
}
