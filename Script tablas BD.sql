--Tablas Taller 4 - APP bancaria
--Juan Pablo Valderrama.

--Tabla para manejo de cuentas.
CREATE TABLE cuenta_bancaria (
    nro_cuenta SERIAL PRIMARY KEY,
    saldo NUMERIC(15, 2),
    titular VARCHAR(255),
    documento_titular VARCHAR(50),
    telefono VARCHAR(20),
    direccion VARCHAR(255),
	email VARCHAR(80)
);

--Tabla para historia de transacciones de cada cuenta.
CREATE TABLE transaccion (
    id_transaccion SERIAL PRIMARY KEY,
    cuenta_asociada INTEGER REFERENCES cuenta_bancaria(nro_cuenta),
    tipo_transaccion VARCHAR(50),
    valor NUMERIC(15, 2),
    fecha DATE,
    hora TIME
);

--Consultas
SELECT * FROM cuenta_bancaria;
SELECT * FROM transaccion;
