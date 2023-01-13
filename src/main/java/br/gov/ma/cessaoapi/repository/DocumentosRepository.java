package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Long> {
}
