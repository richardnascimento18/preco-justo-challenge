package br.com.preco.justo.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientePostRequestDto(
        @NotBlank(message = "NOME_É_OBRIGATÓRIO")
        String nome,

        @NotNull
        boolean elegivelDesconto
) {
}
