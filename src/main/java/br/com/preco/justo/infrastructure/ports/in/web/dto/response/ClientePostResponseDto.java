package br.com.preco.justo.infrastructure.ports.in.web.dto.response;

import java.time.LocalDateTime;

public record ClientePostResponseDto(
        Long id,
        String nome,
        boolean elegivelDesconto,
        LocalDateTime dataCadastro
) {
}
