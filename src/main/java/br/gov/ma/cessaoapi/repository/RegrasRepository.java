package br.gov.ma.cessaoapi.repository;

import br.gov.ma.cessaoapi.domain.Regras;
import br.gov.ma.cessaoapi.dto.RegrasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegrasRepository extends JpaRepository<Regras, Long>, JpaSpecificationExecutor<Regras> {

}
