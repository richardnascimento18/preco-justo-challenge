# 🕓 Cronograma de Desenvolvimento – Projeto **Preço Justo**

Este documento apresenta o cronograma detalhado das etapas de desenvolvimento do sistema **Preço Justo**, incluindo as *user stories*, descrições das tarefas, estimativas reais de tempo e prioridades.

O foco principal foi garantir uma arquitetura limpa, versionamento de banco via Flyway, modelagem clara das entidades e implementação funcional do fluxo de vendas.

---

## 📋 **Cronograma Detalhado**

| Etapa  | User Story                                       | Descrição                                                                                                                                         | Estimativa (h) | Prioridade |
| ------ | ------------------------------------------------ |---------------------------------------------------------------------------------------------------------------------------------------------------|----------------| ---------- |
| **1**  | 🧩 **Setup do Projeto**                          | Configuração inicial do projeto Spring Boot, controle de versão com Git, setup do Docker Compose e Flyway para versionamento do banco. ✅          | **1h**         | **ALTA**   |
| **2**  | 💾 **Modelagem do Banco de Dados**               | Definição das entidades principais, relacionamentos, e criação dos scripts Flyway (V1–V3). ✅                                                      | **1h**         | **ALTA**   |
| **3**  | 🦆 **Cadastro de Patos**                         | Como **vendedor**, quero cadastrar patos individualmente, informando nome e mãe, para rastrear sua linhagem. ✅                                    | **1h**         | **ALTA**   |
| **4**  | 👥 **Cadastro de Clientes**                      | Como **cliente**, quero poder me cadastrar no sistema para realizar compras. ✅                                                                    | **1h**         | **ALTA**   |
| **5**  | 🧑‍💼 **Cadastro de Vendedores**                 | Como **vendedor**, quero poder me cadastrar com CPF e matrícula únicos. ~✅ (implementação parcial, faltam ajustes de validação e DELETE endpoint) | **3h**         | **ALTA**   |
| **6**  | 💸 **Registro de Vendas**                        | Como **vendedor**, quero registrar a venda de um ou mais patos a um cliente, aplicando descontos e impedindo revenda do mesmo pato. ✅             | **2h30**       | **ALTA**   |
| **7**  | 📄 **Listagem de Patos Vendidos**                | Como **administrador**, quero listar todos os patos vendidos com data, valor e cliente, para ter visibilidade das transações. (não implementado)  | **2h**         | **MÉDIA**  |
| **8**  | 📊 **Geração de Relatórios (Excel)**             | Como **administrador**, quero gerar relatórios em Excel com detalhes das vendas, clientes e vendedores. (não implementado)                        | **2h30**       | **MÉDIA**  |
| **9**  | 🏆 **Ranking de Vendedores**                     | Como **administrador**, quero visualizar o ranking de vendedores com mais vendas e maior valor total vendido. (não implementado)                  | **2h30**       | **MÉDIA**  |
| **10** | ✅ **Testes Unitários**                 | Implementar testes básicos de integração com JUnit + Mockito para validar as principais regras e fluxos.  ✅                                       | **1h**         | **BAIXA**  |
| **11** | 🧰 **Documentação (README, Cronograma e Diagrama)** | Criação do `README.md`, `Cronograma.md`, e diagrama do banco de dados com explicação dos relacionamentos e tecnologias utilizadas. ✅              | **0.5h**       | **ALTA**   |
| **12** | 🔍 **Revisão e Ajustes Finais**                  | Revisão de código, testes manuais via Postman e ajustes de consistência final do sistema. ✅                                                       | **0.5h**       | **ALTA**   |

---

## 🧠 **Resumo Geral**

| Tipo de Tarefa                  | Tempo Estimado Total |
| ------------------------------- |----------------------|
| Desenvolvimento Core (1–6)      | **9h30**             |
| Funcionalidades Avançadas (7–9) | **7h**               |
| Testes & Documentação (10–12)   | **2h**               |
| **Total Geral**                 | **~ 18h30**          |

---

## ⚙️ **Observações Finais**

* As etapas **1–6** cobrem todas as funcionalidades essenciais para o funcionamento da aplicação (cadastro, venda e regras de negócio).
* As etapas **7–9** foram planejadas, mas não implementadas devido à limitação de tempo.
* As etapas **10–12** foram parcialmente concluídas para garantir documentação e testes básicos.
