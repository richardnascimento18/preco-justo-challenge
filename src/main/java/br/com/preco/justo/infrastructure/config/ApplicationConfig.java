package br.com.preco.justo.infrastructure.config;
import br.com.preco.justo.application.service.ClienteService;
import br.com.preco.justo.application.service.PatoService;
import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PatoService patoService(PatoRepositoryInterface patoRepository) {
        return new PatoService(patoRepository);
    }

    @Bean
    public ClienteService clienteService(ClienteRepositoryInterface clienteRepository) {
        return new ClienteService(clienteRepository);
    }
}
