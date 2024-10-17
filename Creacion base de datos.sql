CREATE TABLE Cuenta (
    cuenta_id SERIAL PRIMARY KEY,
    cliente_id VARCHAR(10) NOT NULL,
    numero_cuenta VARCHAR(20) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(10) NOT NULL CHECK (tipo_cuenta IN ('corriente', 'ahorro')),
    saldo DECIMAL(15, 2)
);

CREATE TABLE Transacciones (
    transaccion_id SERIAL PRIMARY KEY,
    cuenta_id INTEGER REFERENCES Cuenta(cuenta_id) NOT NULL,
    tipo_transaccion VARCHAR(20) NOT NULL CHECK (tipo_transaccion IN ('depósito', 'retiro', 'consulta')),
    monto DECIMAL(15, 2) NOT NULL,
    descripcion VARCHAR(200) NOT NULL
);
ALTER TABLE Transaccion
ADD COLUMN fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

INSERT INTO Cuenta (cliente_id, numero_cuenta, tipo_cuenta, saldo) 
VALUES 
(1, '1234567890', 'corriente', 1000.50),
(2, '0987654321', 'ahorro', 500.75),
(3, '1111222233', 'corriente', 1500.00),
(4, '4444555566', 'ahorro', 250.00),
(5, '7777888899', 'corriente', 2000.25);
