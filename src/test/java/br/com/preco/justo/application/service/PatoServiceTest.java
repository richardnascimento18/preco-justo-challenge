package br.com.preco.justo.application.service;

import br.com.preco.justo.domain.model.Pato;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste unitário para a classe PatoService.
 * Garante que o pato é criado e persistido corretamente através do repositório.
 */
public class PatoServiceTest {

    private PatoRepositoryInterface patoRepository;
    private PatoService patoService;

    @BeforeEach
    void setUp() {
        patoRepository = Mockito.mock(PatoRepositoryInterface.class);
        patoService = new PatoService(patoRepository);
    }

    @Test
    void deveSalvarPatoComSucesso() {
        // Dado um pato válido
        Pato pato = new Pato("Donald", null);
        when(patoRepository.save(any(Pato.class))).thenReturn(pato);

        // Quando o método salvar é chamado
        Pato salvo = patoService.salvar("Donald", null);

        // Então o pato deve ser salvo corretamente
        assertEquals("Donald", salvo.getNome());
        assertNull(salvo.getMaeId());
        verify(patoRepository, times(1)).save(any(Pato.class));
    }
}
