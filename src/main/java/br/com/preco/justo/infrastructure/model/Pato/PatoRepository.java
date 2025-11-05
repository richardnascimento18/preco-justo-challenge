package br.com.preco.justo.infrastructure.model.Pato;

import br.com.preco.justo.domain.model.Pato;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class PatoRepository implements PatoRepositoryInterface {
    private final PatoRepositoryImplementation patoRepositoryImplementation;

    public PatoRepository(PatoRepositoryImplementation patoRepositoryImplementation) {
        this.patoRepositoryImplementation = patoRepositoryImplementation;
    }

    @Override
    public Pato save(Pato pato) {
        PatoImplementation patoImplementation = new PatoImplementation(pato.getNome(), pato.getMaeId(), pato.getStatus());
        PatoImplementation savedPato = patoRepositoryImplementation.save(patoImplementation);
        return new Pato(savedPato.getId(), savedPato.getNome(), savedPato.getMaeId(), savedPato.getStatus(), savedPato.getDataCadastro());
    }
}
