package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Liberacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiberacaoRepository extends JpaRepository<Liberacao, Long> {
}
