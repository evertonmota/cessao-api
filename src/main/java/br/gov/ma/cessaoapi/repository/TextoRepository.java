package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Textos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextoRepository extends JpaRepository<Textos, Long> {
}
