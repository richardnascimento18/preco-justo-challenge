package br.com.preco.justo.application.service;

import br.com.preco.justo.domain.model.Pato;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Pato.PatoServiceInterface;

public class PatoService implements PatoServiceInterface {
    private final PatoRepositoryInterface patoRepository;

    public PatoService(PatoRepositoryInterface patoRepository) {
        this.patoRepository = patoRepository;
    }

    @Override
    public Pato salvar(String nome, Long maeId) {
        Pato pato = new Pato(nome, maeId);
        return patoRepository.save(pato);
    }
}
