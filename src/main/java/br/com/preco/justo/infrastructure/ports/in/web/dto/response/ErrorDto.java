package br.com.preco.justo.infrastructure.ports.in.web.dto.response;

public class ErrorDto {
    private final String code;
    private final String error;

    public ErrorDto(String code, String error) {
        this.code = code;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public String getError() {
        return error;
    }
}

