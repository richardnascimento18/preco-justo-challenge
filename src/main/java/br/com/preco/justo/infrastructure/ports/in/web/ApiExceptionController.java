package br.com.preco.justo.infrastructure.ports.in.web;

import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.preco.justo.infrastructure.ports.in.web.dto.response.ErrorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionController {
    @Value("${app.version}")
    private String appVersion;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDto<ErrorDto>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        ErrorDto errorDto = new ErrorDto("#400", errorMessage);

        ApiResponseDto<ErrorDto> response = new ApiResponseDto<>(
                HttpStatus.BAD_REQUEST.value(),
                appVersion,
                errorDto,
                Map.of()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponseDto<Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
        String message;
        String code;

        if (rootMessage != null && rootMessage.contains("pato_mae_id_fkey")) {
            message = "O_MAEID_ENVIADO_É_INVÁLIDO (not found)";
            code = "FOREIGN_KEY_VIOLATION";
        } else if (rootMessage != null && rootMessage.contains("unique")) {
            message = "O_REGISTRO_JÁ_EXISTE (duplicate)";
            code = "UNIQUE_CONSTRAINT_VIOLATION";
        } else {
            message = "OCORREU_UM_ERRO_DE_INTEGRIDADE_DE_DADOS";
            code = "DATA_INTEGRITY_ERROR";
        }

        ApiResponseDto<Object> response = new ApiResponseDto<>(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                appVersion,
                Map.of("error", code, "details", message),
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto<Object>> handleGeneric(Exception ex) {
        ApiResponseDto<Object> response = new ApiResponseDto<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                appVersion,
                Map.of("error", "UNEXPECTED_ERROR", "details", ex.getMessage()),
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}


