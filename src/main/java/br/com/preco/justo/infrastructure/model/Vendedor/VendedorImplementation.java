package br.com.preco.justo.infrastructure.model.Vendedor;


import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "vendedor",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_cpf_matricula", columnNames = {"cpf", "matricula"})
        }
)
public class VendedorImplementation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = null;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "matricula", nullable = false, length = 20)
    private String matricula;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "data_cadastro", nullable = false, insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime dataCadastro;

    public VendedorImplementation() {
    }

    public VendedorImplementation(String nome, String cpf, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.ativo = true;
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
