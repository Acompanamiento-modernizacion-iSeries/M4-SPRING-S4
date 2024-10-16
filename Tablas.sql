CREATE DATABASE Banco;

CREATE TABLE cuenta (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(20) NOT NULL UNIQUE,
    saldo NUMERIC(15, 2) NOT NULL,
    titular VARCHAR(100) NOT NULL
);



CREATE TABLE transaccion (
    id SERIAL PRIMARY KEY,
    tipo_transaccion VARCHAR(10) NOT NULL, 
    monto NUMERIC(15, 2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cuenta_id BIGINT NOT NULL,
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(id) ON DELETE CASCADE
);


INSERT INTO cuenta (numero_cuenta, saldo, titular) VALUES
('1234567890', 1000.00, 'Juan Pérez'),
('0987654321', 1500.50, 'María Gómez'),
('1122334455', 2500.75, 'Carlos López'),
('2233445566', 500.00, 'Ana Torres'),
('3344556677', 800.25, 'Pedro Martínez');