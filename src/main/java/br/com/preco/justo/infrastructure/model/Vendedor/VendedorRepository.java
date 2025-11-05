package br.com.preco.justo.infrastructure.model.Vendedor;

import br.com.preco.justo.domain.model.Vendedor;
import br.com.preco.justo.domain.ports.out.Vendedor.VendedorRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class VendedorRepository implements VendedorRepositoryInterface {
    private final VendedorRepositoryImplementation vendedorRepositoryImplementation;

    public VendedorRepository(VendedorRepositoryImplementation vendedorRepositoryImplementation) {
        this.vendedorRepositoryImplementation = vendedorRepositoryImplementation;
    }

    @Override
    public Vendedor save(Vendedor vendedor) {
        VendedorImplementation vendedorImplementation = new VendedorImplementation(vendedor.getNome(), vendedor.getCpf(), vendedor.getMatricula());
        VendedorImplementation savedVendedor = vendedorRepositoryImplementation.save(vendedorImplementation);
        return new Vendedor(savedVendedor.getId(), savedVendedor.getNome(), savedVendedor.getCpf(), savedVendedor.getMatricula(), savedVendedor.getAtivo(), savedVendedor.getDataCadastro());
    }
}
