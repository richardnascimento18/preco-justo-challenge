package br.com.preco.justo.infrastructure.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositoryImplementation extends JpaRepository<ClienteImplementation, Long> {
    @Query("SELECT c.elegivelDesconto FROM ClienteImplementation c WHERE c.id = :clienteId")
    Boolean isElegivelDesconto(@Param("clienteId") Long clienteId);
}
