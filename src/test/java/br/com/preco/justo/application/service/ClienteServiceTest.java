package br.com.preco.justo.application.service;

import br.com.preco.justo.domain.model.Cliente;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste unitário para a classe ClienteService.
 * Verifica se a lógica de criação e persistência de clientes funciona corretamente.
 */
public class ClienteServiceTest {

    private ClienteRepositoryInterface clienteRepository;
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        clienteRepository = Mockito.mock(ClienteRepositoryInterface.class);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    void deveSalvarClienteComSucesso() {
        // Dado um cliente válido
        Cliente cliente = new Cliente("João", true);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        // Quando o método salvar é chamado
        Cliente salvo = clienteService.salvar("João", true);

        // Então o cliente deve ser salvo corretamente
        assertEquals("João", salvo.getNome());
        assertTrue(salvo.getElegivelDesconto());
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }
}
