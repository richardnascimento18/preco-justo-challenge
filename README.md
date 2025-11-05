# Preço Justo BACKEND Challenge 2025

API REST desenvolvida em **Java 17** com **Spring Boot 3**, projetada para gerenciar **clientes, vendedores, patos e vendas**, aplicando regras de negócio específicas de desconto e controle de estoque (sem revenda de patos já vendidos).

---

## 🚀 Tecnologias Utilizadas

| Tecnologia            | Descrição                                                         |
|-----------------------| ----------------------------------------------------------------- |
| **Java 17**           | Linguagem principal do projeto                                    |
| **Spring Boot 3.5.7** | Framework principal para criação da API REST                      |
| **Spring Data JPA**   | Mapeamento objeto-relacional e acesso ao banco                    |
| **Spring Validation** | Validação de DTOs e entidades                                     |
| **Spring Security**   | Configuração base de segurança (não implementada em profundidade) |
| **PostgreSQL**        | Banco de dados relacional                                         |
| **Flyway**            | Versionamento e migração automática do esquema do banco           |
| **Docker Compose**    | Orquestração de containers (API + Banco)                          |
| **JUnit + Mockito**   | Frameworks de testes unitários e de integração                    |

---

## 🗄️ Estrutura do Projeto

```
📦 preco-justo
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java/br/com/preco/justo
 ┃ ┃ ┃ ┣ 📂 application      → Serviços e regras de negócio
 ┃ ┃ ┃ ┣ 📂 domain           → Modelos de domínio e interfaces
 ┃ ┃ ┃ ┣ 📂 infrastructure   → Implementações, entidades JPA e repositórios
 ┃ ┃ ┃ ┗ 📄 PrecoJustoApplication.java
 ┃ ┃ ┗ 📂 resources
 ┃ ┃ ┃ ┣ 📂 db/migration     → Scripts Flyway (V1__, V2__, ...)
 ┃ ┃ ┃ ┣ 📄 application.yml  → Configurações da aplicação
 ┣ 📄 docker-compose.yml
 ┣ 📄 pom.xml
 ┗ 📄 README.md
```

---

## 🧱 Configuração do Ambiente

### **Pré-requisitos**

* [Java 17+](https://adoptium.net/)
* [Maven 3.9+](https://maven.apache.org/)
* [Docker & Docker Compose](https://docs.docker.com/)
* [PostgreSQL 15+](https://www.postgresql.org/)

---

## 🐳 Executando a Aplicação com Docker

### 1️ **Subir o banco de dados**

```bash
docker-compose up -d
```

*(Certifique-se de que o container do PostgreSQL está rodando na porta configurada, geralmente `5432`.)*

### 2️ **Rodar a aplicação**

```bash
mvn spring-boot:run
```

A API será inicializada em:

```
http://localhost:8080
```

### 3️ **Flyway**

Os scripts localizados em `src/main/resources/db/migration` serão executados automaticamente ao iniciar a aplicação, criando todas as tabelas e constraints necessárias.

---

## 🧠 Funcionalidades Principais

| Recurso                   | Descrição                                                                                |
| ------------------------- | ---------------------------------------------------------------------------------------- |
| **/api/v1/pato**          | CRUD de patos (com hierarquia de filhotes)                                               |
| **/api/v1/cliente**       | Cadastro de clientes                                                                     |
| **/api/v1/vendedor**      | Cadastro de vendedores                                                                   |
| **/api/v1/venda**         | Registro de vendas com aplicação automática de descontos                                 |
| **Descontos Automáticos** | Aplicação de regras de negócio baseadas em número de filhotes e elegibilidade do cliente |

---

## 🧮 Regras de Negócio (Resumo)

* Preço base por pato: **R$ 70,00**
* Desconto de **R$ 25,00** para patos com **2 ou mais filhotes**
* Desconto de **R$ 20,00** para patos com **1 filhote**
* Clientes elegíveis recebem **20% de desconto adicional**
* Um pato **não pode ser vendido novamente** após marcado como vendido.

---

## 🧪 Testes

Para executar os testes:

```bash
mvn test
```

Os testes cobrem as principais regras de negócio e garantem o comportamento esperado da API.

---

## 📄 Documentação

* `README.md`: instruções de uso e configuração.
* `Cronogram.md`: planejamento das etapas e tempo estimado.
* `db/diagram.png`: diagrama do banco de dados (quando aplicável).
* `http://localhost:8080/swagger-ui/index.html`: documentação da API pelo Swagger.

---

## 👨‍💻 Autor

**Richard Nascimento**
📚 *Estudante de* **Análise e Desenvolvimento de Sistemas na FIAP**
💼 *Software Engineer* focado em **arquitetura de software** e boas práticas de código limpo.