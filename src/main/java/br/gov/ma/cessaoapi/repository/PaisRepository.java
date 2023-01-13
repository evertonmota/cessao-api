package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Pais;
import br.gov.ma.cessaoapi.dto.PaisDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository  extends JpaRepository<Pais, Long> {

    @Query("SELECT new br.gov.ma.cessaoapi.domain.Pais(\n" +
            "p.id, p.nomePais) FROM Pais p WHERE (:nomePais is null or p.nomePais = :nomePais)")
    List<PaisDTO> buscaPaisesPorFiltro(@Param("nomePais") String nomePais, Pageable pageable);
}
