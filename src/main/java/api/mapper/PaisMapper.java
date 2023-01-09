package api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import api.request.PaisRequest;
import api.response.PaisResponse;
import br.gov.ma.cessaoapi.domain.Pais;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaisMapper {

	private final ModelMapper mapper = new ModelMapper();
	
	//retornando pais
	public Pais toPais(PaisRequest request) {
		return mapper.map(request, Pais.class);
	}
	
	//retornando pais response
	public PaisResponse toPaisResponse(Pais pais) {
		return mapper.map(pais, PaisResponse.class);
	}
	
	//retorna uma lista de paises
	public List<PaisResponse> toPaisResponseList(List<Pais> paises){
		return paises.stream()
				.map(this::toPaisResponse)
				.collect(Collectors.toList());
	}
	
}
