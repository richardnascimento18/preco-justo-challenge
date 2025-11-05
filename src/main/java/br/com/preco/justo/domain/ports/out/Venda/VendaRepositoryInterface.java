package br.com.preco.justo.domain.ports.out.Venda;

import br.com.preco.justo.domain.model.Venda;

public interface VendaRepositoryInterface {
    Venda save(Venda venda);
}
