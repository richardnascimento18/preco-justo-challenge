-- V7__create_venda_and_venda_pato_tables.sql

-- Create main table: venda
CREATE TABLE venda (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES cliente(id) ON DELETE CASCADE,
    vendedor_id BIGINT NOT NULL REFERENCES vendedor(id) ON DELETE CASCADE,
    valor_total DECIMAL(10,2) NOT NULL CHECK (valor_total >= 0),
    data_venda TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create intermediary table: venda_pato
CREATE TABLE venda_pato (
    id BIGSERIAL PRIMARY KEY,
    venda_id BIGINT NOT NULL REFERENCES venda(id) ON DELETE CASCADE,
    pato_id BIGINT NOT NULL REFERENCES pato(id) ON DELETE CASCADE,
    valor_unitario DECIMAL(10,2) NOT NULL CHECK (valor_unitario >= 0)
);

ALTER TABLE venda_pato ADD CONSTRAINT unique_venda_pato UNIQUE (venda_id, pato_id);
