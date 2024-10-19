DROP TABLE IF EXISTS transacciones;
DROP TABLE IF EXISTS cuentas;

CREATE TABLE IF NOT EXISTS cuentas (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255),
    tipo VARCHAR(255),
    saldo DECIMAL
);

CREATE TABLE IF NOT EXISTS transacciones (
    id BIGINT PRIMARY KEY,
    cuenta_id BIGINT,
    tipo VARCHAR(255),
    fecha_transaccion DATE,
    monto DECIMAL,
    FOREIGN KEY (cuenta_id) REFERENCES cuentas(id)
);