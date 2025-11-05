package br.com.preco.justo.infrastructure.ports.in.web.dto.response;

import java.time.LocalDateTime;

public record VendedorPostResponseDto(
        Long id,
        String nome,
        String matricula,
        boolean ativo,
        LocalDateTime dataCadastro
) {
}
