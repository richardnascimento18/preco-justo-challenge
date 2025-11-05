package br.com.preco.justo.domain.ports.out.Vendedor;

import br.com.preco.justo.domain.model.Vendedor;

public interface VendedorRepositoryInterface {
    Vendedor save(Vendedor vendedor);
}
