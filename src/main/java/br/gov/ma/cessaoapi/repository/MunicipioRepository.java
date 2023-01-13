package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Municipios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipios, Long> {
}
