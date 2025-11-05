-- V3__create_cliente_table.sql

CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    elegivel_desconto BOOLEAN NOT NULL DEFAULT FALSE,
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
