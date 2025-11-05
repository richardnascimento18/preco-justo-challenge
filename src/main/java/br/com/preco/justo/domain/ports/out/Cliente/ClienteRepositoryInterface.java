package br.com.preco.justo.domain.ports.out.Cliente;

import br.com.preco.justo.domain.model.Cliente;

public interface ClienteRepositoryInterface {
    Cliente save(Cliente cliente);
    boolean isElegivelDesconto(Long id);
}
