-- V8__update_pato_enum_and_cleanup.sql

-- Make sure the status column can hold text
ALTER TABLE pato
    ALTER COLUMN status TYPE VARCHAR(20);

-- Convert existing numeric statuses (if any) to string equivalents
UPDATE pato
SET status = CASE
                 WHEN status = '0' THEN 'DISPONIVEL'
                 WHEN status = '1' THEN 'VENDIDO'
                 ELSE status
    END;

-- Ensure no nulls (set default to DISPONIVEL if missing)
UPDATE pato
SET status = 'DISPONIVEL'
WHERE status IS NULL OR TRIM(status) = '';

-- Set default value and constraint for status
ALTER TABLE pato
    ALTER COLUMN status SET DEFAULT 'DISPONIVEL';

ALTER TABLE pato
    ADD CONSTRAINT chk_pato_status CHECK (status IN ('DISPONIVEL', 'VENDIDO'));

-- Ensure venda_pato references are clean and unique
ALTER TABLE venda_pato
    DROP CONSTRAINT IF EXISTS unique_venda_pato;

ALTER TABLE venda_pato
    ADD CONSTRAINT unique_venda_pato UNIQUE (venda_id, pato_id);

-- Ensure DECIMAL precision for valor_unitario
ALTER TABLE venda_pato
    ALTER COLUMN valor_unitario TYPE DECIMAL(10,2)
        USING valor_unitario::DECIMAL(10,2);
