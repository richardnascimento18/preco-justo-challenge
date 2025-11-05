package br.com.preco.justo.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VendaPostRequestDto(
        @NotNull(message = "CLIENTE_ID_É_OBRIGATÓRIO")
        Long clienteId,

        @NotNull(message = "VENDEDOR_ID_É_OBRIGATÓRIO")
        Long vendedorId,

        @NotEmpty(message = "LISTA_DE_PATOS_NÃO_PODE_SER_VAZIA")
        List<Long> patosIds
) { }
