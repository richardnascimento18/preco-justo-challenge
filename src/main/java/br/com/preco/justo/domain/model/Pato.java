package br.com.preco.justo.domain.model;

import br.com.preco.justo.domain.enums.PatoStatusEnum;

import java.time.LocalDateTime;

public class Pato {
    private Long id = null;
    private String nome;
    private Long maeId;
    private PatoStatusEnum status = PatoStatusEnum.DISPONIVEL;
    private LocalDateTime dataCadastro;

    public Pato(Long id, String nome, Long maeId, PatoStatusEnum status, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.maeId = maeId;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }

    public Pato(String nome, Long maeId) {
        this.nome = nome;
        this.maeId = maeId;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public Long getMaeId() {
        return maeId;
    }

    public PatoStatusEnum getStatus() {
        return status;
    }
}
