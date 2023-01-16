package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargos, Long> {
    List<Cargos> findAllByEntesExternosIdOrderByNomeCargo(Long identeExterno);
}
