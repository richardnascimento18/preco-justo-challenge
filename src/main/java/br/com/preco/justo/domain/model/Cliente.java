package br.com.preco.justo.domain.model;

import java.time.LocalDateTime;

public class Cliente {
    private Long id;
    private String nome;
    private boolean elegivelDesconto;
    private LocalDateTime dataCadastro;

    public Cliente(Long id, String nome, boolean elegivelDesconto, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.elegivelDesconto = elegivelDesconto;
        this.dataCadastro = dataCadastro;
    }

    public Cliente(String nome, boolean elegivelDesconto) {
        this.nome = nome;
        this.elegivelDesconto = elegivelDesconto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean getElegivelDesconto() {
        return elegivelDesconto;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
