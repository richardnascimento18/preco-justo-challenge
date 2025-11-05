package br.com.preco.justo.application.service;

import br.com.preco.justo.application.util.MatriculaGenerator;
import br.com.preco.justo.domain.model.Vendedor;
import br.com.preco.justo.domain.ports.out.Vendedor.VendedorRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste unitário para a classe VendedorService.
 * Valida a geração de matrícula e persistência de um novo vendedor.
 */
public class VendedorServiceTest {

    private VendedorRepositoryInterface vendedorRepository;
    private VendedorService vendedorService;

    @BeforeEach
    void setUp() {
        vendedorRepository = Mockito.mock(VendedorRepositoryInterface.class);
        vendedorService = new VendedorService(vendedorRepository);
    }

    @Test
    void deveSalvarVendedorComMatriculaGerada() {
        // Mock da classe utilitária MatriculaGenerator
        try (MockedStatic<MatriculaGenerator> mocked = Mockito.mockStatic(MatriculaGenerator.class)) {
            MatriculaGenerator.MatriculaResult result =
                    new MatriculaGenerator.MatriculaResult("12345678900", "VEN-001");

            mocked.when(() -> MatriculaGenerator.gerarMatricula(any(), any())).thenReturn(result);

            Vendedor vendedor = new Vendedor("Maria", "12345678900", "VEN-001");
            when(vendedorRepository.save(any(Vendedor.class))).thenReturn(vendedor);

            // Quando o método salvar é chamado
            Vendedor salvo = vendedorService.salvar("Maria", "123.456.789-00");

            // Então o vendedor deve possuir matrícula e CPF limpo
            assertEquals("12345678900", salvo.getCpf());
            assertEquals("VEN-001", salvo.getMatricula());
            verify(vendedorRepository, times(1)).save(any(Vendedor.class));
        }
    }
}
