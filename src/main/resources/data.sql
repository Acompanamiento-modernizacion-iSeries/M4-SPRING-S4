INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (1, 'Goku', 'Ahorro', 1000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (2, 'Vegeta', 'Corriente', 2000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (3, 'Gohan', 'Ahorro', 3000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (4, 'Trunks', 'Corriente', 4000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (5, 'Goten', 'Ahorro', 5000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (6, 'Piccolo', 'Corriente', 6000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (7, 'Krillin', 'Ahorro', 7000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (8, 'Yamcha', 'Corriente', 8000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (9, 'Tenshinhan', 'Ahorro', 9000);
INSERT INTO cuentas (id, nombre, tipo, saldo) VALUES (10, 'Chaoz', 'Corriente', 10000);

-- crear las insercciones para la tabla de transacciones
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (1, 1, 'DEPOSITO', '2024-10-01', 1000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (2, 2, 'DEPOSITO', '2024-10-02', 2000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (3, 3, 'DEPOSITO', '2024-10-03', 3000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (4, 4, 'DEPOSITO', '2024-10-02', 4000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (5, 5, 'DEPOSITO', '2024-10-04', 5000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (6, 6, 'DEPOSITO', '2024-10-03', 6000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (7, 7, 'DEPOSITO', '2024-10-05', 7000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (8, 8, 'DEPOSITO', '2024-10-02', 8000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (9, 9, 'DEPOSITO', '2024-10-01', 9000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (10, 10, 'DEPOSITO', '2024-10-01', 10000);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (11, 1, 'RETIRO', '2024-10-01', 100);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (12, 2, 'RETIRO', '2024-10-02', 200);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (13, 3, 'RETIRO', '2024-10-03', 300);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (14, 4, 'RETIRO', '2024-10-01', 400);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (15, 5, 'RETIRO', '2024-10-05', 500);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (16, 6, 'RETIRO', '2024-10-04', 600);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (17, 7, 'RETIRO', '2024-10-03', 700);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (18, 8, 'RETIRO', '2024-10-01', 800);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (19, 9, 'RETIRO', '2024-10-02', 900);
INSERT INTO transacciones (id, cuenta_id, tipo, fecha_transaccion, monto) VALUES (20, 10, 'RETIRO', '2024-10-01', 1000);

