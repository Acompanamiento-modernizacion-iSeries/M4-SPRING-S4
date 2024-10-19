CREATE TABLE IF NOT EXISTS cuentas (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255),
    tipo VARCHAR(255),
    saldo DECIMAL
);