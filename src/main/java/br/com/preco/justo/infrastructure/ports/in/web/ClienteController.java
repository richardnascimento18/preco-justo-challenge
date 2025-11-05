package br.com.preco.justo.infrastructure.ports.in.web;

import br.com.preco.justo.application.service.ClienteService;
import br.com.preco.justo.domain.model.Cliente;
import br.com.preco.justo.infrastructure.ports.in.web.dto.request.ClientePostRequestDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ClientePostResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.helper.ApiLinksBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Cliente", description = "Gerenciamento de clientes, incluindo cadastro e elegibilidade para descontos.")
@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Value("${app.version}")
    private String API_VERSION;

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Cadastrar um novo cliente", description = "Adiciona um cliente informando nome e status de elegibilidade para desconto. Retorna o cliente criado.")
    @PostMapping
    public ApiResponseDto<ClientePostResponseDto> add(@Valid @RequestBody ClientePostRequestDto clientePostRequestDto) {
        Cliente cliente = clienteService.salvar(clientePostRequestDto.nome(), clientePostRequestDto.elegivelDesconto());
        ClientePostResponseDto patoPostResponseDto = new ClientePostResponseDto(cliente.getId(), cliente.getNome(), cliente.getElegivelDesconto(), cliente.getDataCadastro());

        Map<String, ApiResponseDto.Link> links = new ApiLinksBuilder()
                .previous("GET", "/api/v1/cliente/{cliente-id}", "get-specific-cliente (to-be-implemented)")
                .current("POST", "/api/v1/cliente", "add-cliente")
                .next("DELETE", "/api/v1/cliente/" + cliente.getId(), "delete-current-cliente (to-be-implemented)")
                .build();

        return new ApiResponseDto<>(201, API_VERSION, patoPostResponseDto, links);
    }
}
