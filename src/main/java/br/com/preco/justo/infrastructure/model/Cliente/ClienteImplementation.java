package br.com.preco.justo.infrastructure.model.Cliente;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
public class ClienteImplementation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = null;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "elegivel_desconto", nullable = false)
    private boolean elegivelDesconto;

    @Column(name = "data_cadastro", nullable = false, insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime dataCadastro;

    public ClienteImplementation() {}

    public ClienteImplementation(String nome, boolean elegivelDesconto) {
        this.nome = nome;
        this.elegivelDesconto = elegivelDesconto;
    }

    public ClienteImplementation(Long id, String nome, boolean elegivelDesconto, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.elegivelDesconto = elegivelDesconto;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isElegivelDesconto() {
        return elegivelDesconto;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
