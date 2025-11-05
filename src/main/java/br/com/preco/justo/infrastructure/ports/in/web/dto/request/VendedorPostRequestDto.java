package br.com.preco.justo.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record VendedorPostRequestDto(
        @NotBlank(message = "NOME_DO_VENDEDOR_É_OBRIGATÓRIO")
        String nome,

        @NotNull(message = "CPF_DO_VENDEDOR_É_OBRIGATÓRIO")
        @CPF(message = "CPF_DEVE_SER_UM_CPF_VALIDO")
        @Pattern(
                regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$",
                message = "CPF_DEVE_ESTAR_FORMATADO_CORRETAMENTE_(XXX.XXX.XXX-XX)"
        )
        String cpf
) {
}
