-- V6__add_unique_constraints_vendedor.sql

-- Drop the old combined constraint
ALTER TABLE vendedor
    DROP CONSTRAINT IF EXISTS unique_cpf_matricula;

-- Add a unique constraint for CPF only
ALTER TABLE vendedor
    ADD CONSTRAINT unique_vendedor_cpf UNIQUE (cpf);

-- Add a unique constraint for matricula only
ALTER TABLE vendedor
    ADD CONSTRAINT unique_vendedor_matricula UNIQUE (matricula);

-- Re-add combined constraint to ensure no same pair
ALTER TABLE vendedor
    ADD CONSTRAINT unique_vendedor_cpf_matricula UNIQUE (cpf, matricula);
