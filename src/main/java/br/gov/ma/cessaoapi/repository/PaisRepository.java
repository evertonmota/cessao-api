package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository  extends JpaRepository<Pais, UUID> {
}
