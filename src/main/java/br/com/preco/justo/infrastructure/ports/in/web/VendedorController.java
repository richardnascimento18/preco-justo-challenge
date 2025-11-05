package br.com.preco.justo.infrastructure.ports.in.web;

import br.com.preco.justo.application.service.ClienteService;
import br.com.preco.justo.application.service.VendedorService;
import br.com.preco.justo.domain.model.Cliente;
import br.com.preco.justo.domain.model.Vendedor;
import br.com.preco.justo.infrastructure.ports.in.web.dto.request.ClientePostRequestDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.request.VendedorPostRequestDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ClientePostResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.VendedorPostResponseDto;
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

@Tag(name = "Vendedor", description = "Cadastro e gerenciamento de vendedores, incluindo controle de CPF e matrícula únicos.")
@RestController
@RequestMapping("/api/v1/vendedor")
public class VendedorController {

    @Value("${app.version}")
    private String API_VERSION;

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @Operation(summary = "Cadastrar um novo vendedor", description = "Cria um novo vendedor informando nome e CPF. Gera automaticamente uma matrícula e define o status como ativo.")
    @PostMapping
    public ApiResponseDto<VendedorPostResponseDto> add(@Valid @RequestBody VendedorPostRequestDto vendedorPostRequestDto) {
        Vendedor createdVendedor = vendedorService.salvar(vendedorPostRequestDto.nome(), vendedorPostRequestDto.cpf());
        VendedorPostResponseDto vendedorPostResponseDto = new VendedorPostResponseDto(createdVendedor.getId(), createdVendedor.getNome(), createdVendedor.getMatricula(), createdVendedor.getAtivo(), createdVendedor.getDataCadastro());

        Map<String, ApiResponseDto.Link> links = new ApiLinksBuilder()
                .previous("GET", "/api/v1/vendedor/{vendedor-id}", "get-specific-vendedor (to-be-implemented)")
                .current("POST", "/api/v1/vendedor", "add-vendedor")
                .next("DELETE", "/api/v1/vendedor/" + createdVendedor.getId(), "delete-current-vendedor (to-be-implemented)")
                .build();

        return new ApiResponseDto<>(201, API_VERSION, vendedorPostResponseDto, links);
    }
}

