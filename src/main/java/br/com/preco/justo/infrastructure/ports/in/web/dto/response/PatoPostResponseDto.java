package br.com.preco.justo.infrastructure.ports.in.web.dto.response;

import br.com.preco.justo.domain.enums.PatoStatusEnum;

import java.time.LocalDateTime;

public record PatoPostResponseDto(
        Long id,
        String name,
        Long maeId,
        PatoStatusEnum status,
        LocalDateTime dataCadastro
) {
}
