package br.com.preco.justo.domain.ports.out.Cliente;

import br.com.preco.justo.domain.model.Cliente;

public interface ClienteServiceInterface {
    Cliente salvar(String nome, boolean elegivelDesconto);
}
