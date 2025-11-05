package br.com.preco.justo.infrastructure.model.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepositoryImplementation extends JpaRepository<VendaImplementation, Long> {
}

