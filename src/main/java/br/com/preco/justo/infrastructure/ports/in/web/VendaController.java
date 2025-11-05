package br.com.preco.justo.infrastructure.ports.in.web;

import br.com.preco.justo.application.service.VendaService;
import br.com.preco.justo.domain.model.Venda;
import br.com.preco.justo.infrastructure.ports.in.web.dto.request.VendaPostRequestDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.VendaPostResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.helper.ApiLinksBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/venda")
public class VendaController {

    @Value("${app.version}")
    private String API_VERSION;

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ApiResponseDto<VendaPostResponseDto> add(@Valid @RequestBody VendaPostRequestDto vendaPostRequestDto) {
        Venda venda = vendaService.salvar(
                vendaPostRequestDto.clienteId(),
                vendaPostRequestDto.vendedorId(),
                vendaPostRequestDto.patosIds()
        );

        VendaPostResponseDto vendaPostResponseDto = new VendaPostResponseDto(
                venda.getId(),
                venda.getClienteId(),
                venda.getVendedorId(),
                venda.getValorTotal(),
                venda.getPatosIds(),
                venda.getDataVenda()
        );

        Map<String, ApiResponseDto.Link> links = new ApiLinksBuilder()
                .previous("GET", "/api/v1/venda/{venda-id}", "get-specific-venda (to-be-implemented)")
                .current("POST", "/api/v1/venda", "add-venda")
                .next("DELETE", "/api/v1/venda/" + venda.getId(), "delete-venda (to-be-implemented)")
                .build();

        return new ApiResponseDto<>(201, API_VERSION, vendaPostResponseDto, links);
    }
}
