package br.com.preco.justo.application.service;

import br.com.preco.justo.application.util.MatriculaGenerator;
import br.com.preco.justo.application.util.MatriculaGenerator.MatriculaResult;
import br.com.preco.justo.domain.model.Vendedor;
import br.com.preco.justo.domain.ports.out.Vendedor.VendedorRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Vendedor.VendedorServiceInterface;

public class VendedorService implements VendedorServiceInterface {
    private final VendedorRepositoryInterface vendedorRepository;

    public VendedorService(VendedorRepositoryInterface vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public Vendedor salvar(String nome, String cpf) {
        MatriculaResult resultado = MatriculaGenerator.gerarMatricula(nome, cpf);
        Vendedor vendedor = new Vendedor(nome, resultado.cpfLimpo(), resultado.matricula());
        return vendedorRepository.save(vendedor);
    }
}
