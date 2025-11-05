package br.com.preco.justo.infrastructure.model.Pato;

import br.com.preco.justo.domain.enums.PatoStatusEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Entity
@Table(name = "pato")
public class PatoImplementation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = null;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "mae_id")
    private Long maeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PatoStatusEnum status;

    @Column(name = "data_cadastro", nullable = false, insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime dataCadastro;

    public PatoImplementation() {}

    public PatoImplementation(String nome, Long maeId, PatoStatusEnum status) {
        this.nome = nome;
        this.maeId = maeId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMaeId() {
        return maeId;
    }

    public void setMaeId(Long maeId) {
        this.maeId = maeId;
    }

    public PatoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PatoStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
