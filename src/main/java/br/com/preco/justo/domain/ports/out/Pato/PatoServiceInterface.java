package br.com.preco.justo.domain.ports.out.Pato;

import br.com.preco.justo.domain.model.Pato;

public interface PatoServiceInterface {
    Pato salvar(String nome, Long idMae);
}
