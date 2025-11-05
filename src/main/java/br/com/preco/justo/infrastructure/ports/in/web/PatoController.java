package br.com.preco.justo.infrastructure.ports.in.web;

import br.com.preco.justo.application.service.PatoService;
import br.com.preco.justo.domain.model.Pato;
import br.com.preco.justo.infrastructure.ports.in.web.dto.request.PatoPostRequestDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.PatoPostResponseDto;
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

@Tag(name = "Pato", description = "Gerenciamento e cadastro de patos, incluindo vínculo com a mãe e status de disponibilidade.")
@RestController
@RequestMapping("/api/v1/pato")
public class PatoController {

    @Value("${app.version}")
    private String API_VERSION;

    private final PatoService patoService;

    public PatoController(PatoService patoService) {
        this.patoService = patoService;
    }

    @Operation(summary = "Cadastrar um novo pato", description = "Cria um novo registro de pato informando nome e ID da mãe (opcional). Retorna o pato criado com status e data de cadastro.")
    @PostMapping
    public ApiResponseDto<PatoPostResponseDto> add(@Valid @RequestBody PatoPostRequestDto patoPostRequestDto) {
        Pato createdPato = patoService.salvar(patoPostRequestDto.nome(), patoPostRequestDto.maeId());
        PatoPostResponseDto patoPostResponseDto = new PatoPostResponseDto(createdPato.getId(), createdPato.getNome(), createdPato.getMaeId(), createdPato.getStatus(), createdPato.getDataCadastro());

        Map<String, ApiResponseDto.Link> links = new ApiLinksBuilder()
                .previous("GET", "/api/v1/pato/{pato-id}", "get-specific-pato (to-be-implemented)")
                .current("POST", "/api/v1/pato", "add-pato")
                .next("DELETE", "/api/v1/pato/" + createdPato.getId(), "delete-current-pato (to-be-implemented)")
                .build();

        return new ApiResponseDto<>(201, API_VERSION, patoPostResponseDto, links);
    }
}
