package br.com.preco.justo.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record PatoPostRequestDto(
        @NotBlank(message = "NOME_DO_PATO_É_OBRIGATÓRIO")
        String nome,

        @PositiveOrZero(message = "ID_DEVE_SER_POSITIVO_OU_ZERO")
        Long maeId
) {
}
