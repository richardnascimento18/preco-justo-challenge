package br.com.preco.justo.application.util;

import br.com.preco.justo.domain.ports.out.Cliente.ClienteRepositoryInterface;
import br.com.preco.justo.domain.ports.out.Pato.PatoRepositoryInterface;
import br.com.preco.justo.infrastructure.model.Cliente.ClienteRepositoryImplementation;
import br.com.preco.justo.infrastructure.model.Pato.PatoRepositoryImplementation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceCalculator {

    /**
     * Calcula o preço total para a compra de patos com base em várias regras de negócio:
     * - Preço base de 50,00 por pato
     * - Desconto de 25,00 para patos com 2 ou mais filhotes
     * - Desconto de 20,00 para patos com 1 filhote
     * - Desconto de 20% para clientes elegíveis
     *
     * @param clienteId         ID do cliente que está a fazer a compra
     * @param patosIds          Lista de IDs de patos que estão sendo comprados
     * @param patoRepository    Repositório para buscar informações sobre filhotes de pato
     * @param clienteRepository Repositório para verificar a elegibilidade do desconto do cliente
     * @return O preço total final calculado considerando todos os descontos aplicáveis
     */
    public static BigDecimal calculateValorTotal(Long clienteId, List<Long> patosIds, PatoRepositoryInterface patoRepository, ClienteRepositoryInterface clienteRepository) {
        List<Object[]> resultados = patoRepository.findQuantidadeDeFilhosPorMaeIds(patosIds);

        Map<Long, Long> filhosPorMae = resultados.stream()
                .collect(Collectors.toMap(
                        r -> (Long) r[0],
                        r -> (Long) r[1]
                ));

        BigDecimal valorTotal = BigDecimal.ZERO;
        BigDecimal precoBase = new BigDecimal("70.00");

        for (Long patoId : patosIds) {
            Long filhos = filhosPorMae.getOrDefault(patoId, 0L);
            BigDecimal preco = precoBase;

            if (filhos >= 2) preco = preco.subtract(new BigDecimal("20.00"));
            else if (filhos == 1) preco = preco.subtract(new BigDecimal("45.00"));

            valorTotal = valorTotal.add(preco);
        }

        if (clienteRepository.isElegivelDesconto(clienteId))
            valorTotal = valorTotal.multiply(new BigDecimal("0.8"));

        return valorTotal;
    }

    /**
     * Calcula o preço unitário de cada pato em uma venda, com base nas regras de negócio:
     * - Preço base de R$70,00 por pato
     * - Desconto de R$25,00 se o pato tiver 2 ou mais filhotes
     * - Desconto de R$20,00 se o pato tiver 1 filhote
     * - Desconto adicional de 20% se o cliente for elegível
     *
     * Este método retorna um mapa onde a chave é o ID do pato e o valor é o preço final individual.
     */
    public static Map<Long, BigDecimal> calculatePrecoPorPato(List<Long> patosIds,
                                                              PatoRepositoryImplementation patoRepository) {

        List<Object[]> resultados = patoRepository.findQuantidadeDeFilhosPorMaeIds(patosIds);
        Map<Long, Long> filhosPorMae = resultados.stream()
                .collect(Collectors.toMap(r -> (Long) r[0], r -> (Long) r[1]));

        Map<Long, BigDecimal> precosPorPato = patosIds.stream()
                .collect(Collectors.toMap(
                        patoId -> patoId,
                        patoId -> {
                            Long filhos = filhosPorMae.getOrDefault(patoId, 0L);
                            BigDecimal preco = new BigDecimal("70.00");

                            if (filhos >= 2) preco = preco.subtract(new BigDecimal("20.00"));
                            else if (filhos == 1) preco = preco.subtract(new BigDecimal("45.00"));

                            return preco;
                        }
                ));

        return precosPorPato;
    }


}
