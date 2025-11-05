package br.com.preco.justo.infrastructure.ports.in.web.helper;

import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ApiResponseDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiLinksBuilder {

    private final Map<String, ApiResponseDto.Link> links = new LinkedHashMap<>();

    public ApiLinksBuilder previous(String method, String url, String rel) {
        links.put("previous", new ApiResponseDto.Link(method, url, rel));
        return this;
    }

    public ApiLinksBuilder current(String method, String url, String rel) {
        links.put("current", new ApiResponseDto.Link(method, url, rel));
        return this;
    }

    public ApiLinksBuilder next(String method, String url, String rel) {
        links.put("next", new ApiResponseDto.Link(method, url, rel));
        return this;
    }

    public Map<String, ApiResponseDto.Link> build() {
        return links;
    }
}

