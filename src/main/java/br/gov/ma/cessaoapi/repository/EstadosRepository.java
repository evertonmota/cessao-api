package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Estados;
import br.gov.ma.cessaoapi.dto.EstadosDTO;
import br.gov.ma.cessaoapi.errors.BusinessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long> {

    @Query("SELECT new br.gov.ma.cessaoapi.dto.EstadosDTO(e.id, e.nome, e.sigla, e.pais.id) from Estados e \n" +
            "inner join Pais p on e.pais = p\n" +
            "where (:nomeEstado is null or e.nome = :nomeEstado)\n" +
            "AND (:sigla is null or e.sigla = :sigla)\n" +
            "AND (:id is null or e.id = :id)\n" +
            "AND (:idPais is null or p.id = :idPais)")
    List<EstadosDTO> buscaEstadoPorFiltros(@Param("nome") String nome, @Param("sigla") String sigla,
                                           @Param("id") Long id, @Param("idPais") Long idPais, Pageable pageable) throws BusinessException;
}
