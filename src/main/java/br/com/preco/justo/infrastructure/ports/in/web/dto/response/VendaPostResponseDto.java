package br.com.preco.justo.infrastructure.ports.in.web.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VendaPostResponseDto(
        Long id,
        Long clienteId,
        Long vendedorId,
        BigDecimal valorTotal,
        List<Long> patosIds,
        LocalDateTime dataVenda
) { }
