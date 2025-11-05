package br.com.preco.justo.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI precoJustoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Preço Justo API")
                        .description("API para gerenciamento de patos, clientes, vendedores e vendas")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação Completa")
                        .url("https://github.com/richardnascimento18/preco-justo-challenge"));
    }
}
