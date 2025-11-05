package br.com.preco.justo.domain.ports.out.Pato;

import br.com.preco.justo.domain.model.Pato;

import java.util.List;

public interface PatoRepositoryInterface {
    Pato save(Pato pato);
    List<Object[]> findQuantidadeDeFilhosPorMaeIds(List<Long> patoIds);
}
