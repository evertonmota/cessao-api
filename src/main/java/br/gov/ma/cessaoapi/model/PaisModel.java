package br.gov.ma.cessaoapi.model;

import br.gov.ma.cessaoapi.domain.Pais;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@ToString
public class PaisModel {

    private UUID id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2 ,  max = 100, message = "O tamanho deve ser entre 10 e até 100 digitos")
    private String nomePais;

}
