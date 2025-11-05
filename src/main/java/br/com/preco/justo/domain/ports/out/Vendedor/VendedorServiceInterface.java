package br.com.preco.justo.domain.ports.out.Vendedor;

import br.com.preco.justo.domain.model.Vendedor;

public interface VendedorServiceInterface {
    Vendedor salvar(String nome, String cpf);
}
