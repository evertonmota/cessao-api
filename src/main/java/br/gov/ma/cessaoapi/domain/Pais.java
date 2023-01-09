package br.gov.ma.cessaoapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
@Entity
public class Pais {

    @Id
    @GeneratedValue
    private UUID id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2 ,  max = 100, message = "O tamanho deve ser entre 10 e até 100 digitos")
    private String nomePais;

}
