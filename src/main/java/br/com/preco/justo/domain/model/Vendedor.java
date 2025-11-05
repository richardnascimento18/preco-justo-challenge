package br.com.preco.justo.domain.model;

import java.time.LocalDateTime;

public class Vendedor {
    private Long id;
    private String nome;
    private String cpf;
    private String matricula;
    private Boolean ativo;
    private LocalDateTime dataCadastro;

    public Vendedor(Long id, String nome, String cpf, String matricula, Boolean ativo, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public Vendedor(String nome, String cpf, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.ativo = true; // padrão
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
