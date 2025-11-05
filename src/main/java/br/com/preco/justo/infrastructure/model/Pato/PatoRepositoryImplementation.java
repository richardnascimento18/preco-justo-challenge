package br.com.preco.justo.infrastructure.model.Pato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatoRepositoryImplementation extends JpaRepository<PatoImplementation, Long> {
    @Query("""
        SELECT p.maeId, COUNT(p)
        FROM PatoImplementation p
        WHERE p.maeId IN :patoIds
        GROUP BY p.maeId
    """)
    List<Object[]> findQuantidadeDeFilhosPorMaeIds(List<Long> patoIds);
}
