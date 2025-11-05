package br.com.preco.justo.infrastructure.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryImplementation extends JpaRepository<ClienteImplementation, Long> {
}
