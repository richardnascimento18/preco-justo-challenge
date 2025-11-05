package br.com.preco.justo.infrastructure.ports.in.web.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = false)
public record ClientePostRequestDto(
        @NotBlank(message = "NOME_É_OBRIGATÓRIO")
        String nome,

        @NotNull(message = "ELEGIVEL_DESCONTO_É_OBRIGATÓRIO")
        boolean elegivelDesconto
) {
}
