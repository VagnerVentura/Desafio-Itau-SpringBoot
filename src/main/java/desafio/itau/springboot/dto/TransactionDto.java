package desafio.itau.springboot.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransactionDto (
		@NotNull  @Min(0) Double valor, 
		@NotNull OffsetDateTime dataHora
		){}
