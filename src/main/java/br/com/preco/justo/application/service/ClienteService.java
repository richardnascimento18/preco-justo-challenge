package br.com.preco.justo.application.service;

import br.com.preco.justo.domain.model.Cliente;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteServiceInterface;

public class ClienteService implements ClienteServiceInterface {
    private final ClienteRepositoryInterface clienteRepository;

    public ClienteService(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvar(String nome, boolean elegivelDesconto) {
        Cliente cliente = new Cliente(nome, elegivelDesconto);
        return clienteRepository.save(cliente);
    }
}
