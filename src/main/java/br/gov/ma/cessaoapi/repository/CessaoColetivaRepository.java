package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.CessaoColetiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CessaoColetivaRepository extends JpaRepository<CessaoColetiva, Long> {
}
