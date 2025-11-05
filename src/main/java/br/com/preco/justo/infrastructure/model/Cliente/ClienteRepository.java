package br.com.preco.justo.infrastructure.model.Cliente;

import br.com.preco.justo.domain.model.Cliente;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements ClienteRepositoryInterface {
    private final ClienteRepositoryImplementation clienteRepositoryImplementation;

    public ClienteRepository(ClienteRepositoryImplementation clienteRepositoryImplementation) {
        this.clienteRepositoryImplementation = clienteRepositoryImplementation;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteImplementation clienteImplementation = new ClienteImplementation(cliente.getNome(), cliente.getElegivelDesconto());
        ClienteImplementation savedCliente = clienteRepositoryImplementation.save(clienteImplementation);
        return new Cliente(savedCliente.getId(), savedCliente.getNome(), savedCliente.isElegivelDesconto(), savedCliente.getDataCadastro());
    }

    @Override
    public boolean isElegivelDesconto(Long id) {
        return clienteRepositoryImplementation.isElegivelDesconto(id);
    }
}
