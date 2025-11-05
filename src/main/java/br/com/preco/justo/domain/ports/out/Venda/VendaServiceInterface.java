package br.com.preco.justo.domain.ports.out.Venda;

import br.com.preco.justo.domain.model.Venda;

import java.util.List;

public interface VendaServiceInterface {
    Venda salvar(Long clienteId, Long vendedorId, List<Long> patosIds);
}
