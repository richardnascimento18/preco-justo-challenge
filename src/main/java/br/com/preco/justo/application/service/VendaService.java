package br.com.preco.justo.application.service;

import br.com.preco.justo.application.util.PriceCalculator;
import br.com.preco.justo.domain.model.Venda;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Venda.VendaRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Venda.VendaServiceInterface;

import java.math.BigDecimal;
import java.util.List;

public class VendaService implements VendaServiceInterface {
    private final VendaRepositoryInterface vendaRepository;
    private final PatoRepositoryInterface patoRepository;
    private final ClienteRepositoryInterface clienteRepository;

    public VendaService(VendaRepositoryInterface vendaRepository, PatoRepositoryInterface patoRepository, ClienteRepositoryInterface clienteRepository) {
        this.vendaRepository = vendaRepository;
        this.patoRepository = patoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Venda salvar(Long clienteId, Long vendedorId, List<Long> patosIds) {
        BigDecimal valorTotal = PriceCalculator.calculateValorTotal(clienteId, patosIds, patoRepository, clienteRepository);

        Venda venda = new Venda(clienteId, vendedorId, valorTotal, patosIds);
        return vendaRepository.save(venda);
    }
}
