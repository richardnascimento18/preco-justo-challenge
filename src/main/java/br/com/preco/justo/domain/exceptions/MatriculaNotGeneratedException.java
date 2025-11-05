package br.com.preco.justo.domain.exceptions;

public class MatriculaNotGeneratedException extends RuntimeException {
    public MatriculaNotGeneratedException(String message) {
        super(message);
    }
}
