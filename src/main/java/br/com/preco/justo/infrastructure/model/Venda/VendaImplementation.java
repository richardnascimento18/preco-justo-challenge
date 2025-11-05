package br.com.preco.justo.infrastructure.model.Venda;

import br.com.preco.justo.infrastructure.model.Cliente.ClienteImplementation;
import br.com.preco.justo.infrastructure.model.Vendedor.VendedorImplementation;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venda")
public class VendaImplementation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteImplementation cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private VendedorImplementation vendedor;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "data_venda", nullable = false)
    private LocalDateTime dataVenda = LocalDateTime.now();

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaPatoImplementation> vendaPatos = new ArrayList<>();

    public VendaImplementation() {}

    public VendaImplementation(ClienteImplementation cliente,
                               VendedorImplementation vendedor,
                               BigDecimal valorTotal,
                               List<VendaPatoImplementation> vendaPatos) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valorTotal = valorTotal;
        this.vendaPatos = vendaPatos;
    }

    public Long getId() { return id; }
    public ClienteImplementation getCliente() { return cliente; }
    public VendedorImplementation getVendedor() { return vendedor; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public LocalDateTime getDataVenda() { return dataVenda; }
    public List<VendaPatoImplementation> getVendaPatos() { return vendaPatos; }
}

