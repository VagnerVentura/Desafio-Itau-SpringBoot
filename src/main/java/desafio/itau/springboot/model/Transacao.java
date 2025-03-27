package desafio.itau.springboot.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transacao {

	@NotBlank
	private BigDecimal valor;
	
	@NotBlank
	private OffsetDateTime dataHora;	
	
	
}
