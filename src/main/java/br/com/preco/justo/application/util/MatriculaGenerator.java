package br.com.preco.justo.application.util;

import br.com.preco.justo.domain.exceptions.MatriculaNotGeneratedException;

public class MatriculaGenerator {
    public record MatriculaResult(String matricula, String cpfLimpo) {}

    /**
     * Gera uma matricula única no formato:
     * PJ_{INICIAIS_DO_NOME}_{ÚLTIMOS_4_DIGITOS_CPF}
     *
     * Exemplo:
     * Nome: "Carlos Alberto Nobrega"
     * CPF: "482.128.832-18"
     * Resultado: "PJ_CAN_3218"
     *
     * @param nome o nome completo do cliente
     * @param cpf o CPF do cliente (sem pontuações ou traços)
     * @return um objeto de MatriculaResult com a matricula gerada e o cpf limpo
     */
    public static MatriculaResult gerarMatricula(String nome, String cpf) {
        if (nome == null || cpf == null || nome.isBlank() || cpf.isBlank()) {
            throw new MatriculaNotGeneratedException("NOME_E_CPF_NÃO_PODEM_SER_NULOS_OU_VAZIOS");
        }

        String cpfNumerico = cpf.replaceAll("\\D", "");
        String ultimos4Cpf = cpfNumerico.length() >= 4
                ? cpfNumerico.substring(cpfNumerico.length() - 4)
                : cpfNumerico;

        String[] partesNome = nome.trim().split("\\s+");
        StringBuilder iniciais = new StringBuilder();

        for (String parte : partesNome) {
            if (!parte.isBlank()) {
                iniciais.append(Character.toUpperCase(parte.charAt(0)));
            }
            if (iniciais.length() == 3) break;
        }

        String matricula = "PJ_" + iniciais + "_" + ultimos4Cpf;
        return new MatriculaResult(matricula, cpfNumerico);
    }
}
