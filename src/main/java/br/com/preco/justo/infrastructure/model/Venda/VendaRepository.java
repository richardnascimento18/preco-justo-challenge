package br.com.preco.justo.infrastructure.model.Venda;

import br.com.preco.justo.application.util.PriceCalculator;
import br.com.preco.justo.domain.enums.PatoStatusEnum;
import br.com.preco.justo.domain.model.Venda;
import br.com.preco.justo.domain.ports.out.Venda.VendaRepositoryInterface;
import br.com.preco.justo.infrastructure.model.Cliente.ClienteRepositoryImplementation;
import br.com.preco.justo.infrastructure.model.Pato.PatoRepositoryImplementation;
import br.com.preco.justo.infrastructure.model.Vendedor.VendedorRepositoryImplementation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class VendaRepository implements VendaRepositoryInterface {

    private final VendaRepositoryImplementation vendaRepositoryImplementation;
    private final ClienteRepositoryImplementation clienteRepositoryImplementation;
    private final VendedorRepositoryImplementation vendedorRepositoryImplementation;
    private final PatoRepositoryImplementation patoRepositoryImplementation;

    public VendaRepository(VendaRepositoryImplementation vendaRepositoryImplementation, ClienteRepositoryImplementation clienteRepositoryImplementation, VendedorRepositoryImplementation vendedorRepositoryImplementation, PatoRepositoryImplementation patoRepositoryImplementation) {
        this.vendaRepositoryImplementation = vendaRepositoryImplementation;
        this.clienteRepositoryImplementation = clienteRepositoryImplementation;
        this.vendedorRepositoryImplementation = vendedorRepositoryImplementation;
        this.patoRepositoryImplementation = patoRepositoryImplementation;
    }

    @Override
    public Venda save(Venda venda) {
        var cliente = clienteRepositoryImplementation.findById(venda.getClienteId())
                .orElseThrow(() -> new RuntimeException("CLIENTE_NÃO_ENCONTRADO"));
        var vendedor = vendedorRepositoryImplementation.findById(venda.getVendedorId())
                .orElseThrow(() -> new RuntimeException("VENDEDOR_NÃO_ENCONTRADO"));
        var patos = patoRepositoryImplementation.findAllById(venda.getPatosIds());

        VendaImplementation vendaEntity = new VendaImplementation(cliente, vendedor, venda.getValorTotal(), new ArrayList<>());

        Map<Long, BigDecimal> precosPorPato = PriceCalculator.calculatePrecoPorPato(patos.stream().map(p -> p.getId()).toList(), patoRepositoryImplementation);

        List<VendaPatoImplementation> vendaPatos = patos.stream()
                .map(p -> new VendaPatoImplementation(vendaEntity, p, precosPorPato.get(p.getId())))
                .collect(Collectors.toList());



        vendaEntity.getVendaPatos().addAll(vendaPatos);

        patos.forEach(p -> p.setStatus(PatoStatusEnum.VENDIDO));
        patoRepositoryImplementation.saveAll(patos);

        VendaImplementation saved = vendaRepositoryImplementation.save(vendaEntity);

        return new Venda(
                saved.getId(),
                saved.getCliente().getId(),
                saved.getVendedor().getId(),
                saved.getValorTotal(),
                saved.getDataVenda(),
                saved.getVendaPatos().stream()
                        .map(vp -> vp.getPato().getId())
                        .collect(Collectors.toList())
        );
    }
}

