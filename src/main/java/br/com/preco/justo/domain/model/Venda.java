package br.com.preco.justo.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Venda {
    private Long id;
    private Long clienteId;
    private Long vendedorId;
    private BigDecimal valorTotal;
    private List<Long> patosIds;
    private LocalDateTime dataVenda;

    public Venda(Long clienteId, Long vendedorId, BigDecimal valorTotal, List<Long> patosIds) {
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.valorTotal = valorTotal;
        this.patosIds = patosIds;
    }

    public Venda(Long id, Long clienteId, Long vendedorId, BigDecimal valorTotal, LocalDateTime dataVenda, List<Long> patosIds) {
        this.id = id;
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.patosIds = patosIds;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public List<Long> getPatosIds() {
        return patosIds;
    }
}
