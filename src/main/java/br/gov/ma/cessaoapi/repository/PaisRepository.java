package br.gov.ma.cessaoapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.ma.cessaoapi.domain.Pais;

@Repository
public interface PaisRepository  extends JpaRepository<Pais, UUID> {
}
