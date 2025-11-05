package br.com.preco.justo.infrastructure.model.Venda;

import jakarta.persistence.*;
import java.math.BigDecimal;
import br.com.preco.justo.infrastructure.model.Pato.PatoImplementation;

@Entity
@Table(name = "venda_pato")
public class VendaPatoImplementation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_id", nullable = false)
    private VendaImplementation venda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pato_id", nullable = false)
    private PatoImplementation pato;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

    public VendaPatoImplementation() {}

    public VendaPatoImplementation(VendaImplementation venda, PatoImplementation pato, BigDecimal valorUnitario) {
        this.venda = venda;
        this.pato = pato;
        this.valorUnitario = valorUnitario;
    }

    public Long getId() { return id; }
    public VendaImplementation getVenda() { return venda; }
    public PatoImplementation getPato() { return pato; }
    public BigDecimal getValorUnitario() { return valorUnitario; }
}

