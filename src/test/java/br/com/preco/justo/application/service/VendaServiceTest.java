package br.com.preco.justo.application.service;

import br.com.preco.justo.application.util.PriceCalculator;
import br.com.preco.justo.domain.model.Venda;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Venda.VendaRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste unitário para a classe VendaService.
 * Foca na integração entre a lógica de cálculo de preço e a persistência da venda.
 */
public class VendaServiceTest {

    private VendaRepositoryInterface vendaRepository;
    private PatoRepositoryInterface patoRepository;
    private ClienteRepositoryInterface clienteRepository;
    private VendaService vendaService;

    @BeforeEach
    void setUp() {
        vendaRepository = Mockito.mock(VendaRepositoryInterface.class);
        patoRepository = Mockito.mock(PatoRepositoryInterface.class);
        clienteRepository = Mockito.mock(ClienteRepositoryInterface.class);
        vendaService = new VendaService(vendaRepository, patoRepository, clienteRepository);
    }

    @Test
    void deveSalvarVendaComValorCalculado() {
        // Mock estático do PriceCalculator
        try (MockedStatic<PriceCalculator> mocked = Mockito.mockStatic(PriceCalculator.class)) {
            mocked.when(() -> PriceCalculator.calculateValorTotal(any(), any(), any(), any()))
                    .thenReturn(new BigDecimal("150.00"));

            Venda vendaEsperada = new Venda(1L, 2L, new BigDecimal("150.00"), List.of(10L, 20L));
            when(vendaRepository.save(any(Venda.class))).thenReturn(vendaEsperada);

            // Quando o método salvar é chamado
            Venda resultado = vendaService.salvar(1L, 2L, List.of(10L, 20L));

            // Então o valor total deve corresponder ao calculado
            assertEquals(new BigDecimal("150.00"), resultado.getValorTotal());
            verify(vendaRepository, times(1)).save(any(Venda.class));
        }
    }
}
