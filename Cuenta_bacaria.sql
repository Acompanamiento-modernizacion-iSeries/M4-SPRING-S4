create table cuenta_bancaria(
    cuenta_id serial PRIMARY KEY,
	titular numeric not null,
	saldo numeric not null
);

insert into cuenta_bancaria(titular, saldo) values( 1037575512, 1500000);
insert into cuenta_bancaria(titular, saldo) values( 1024564326, 6000000);
insert into cuenta_bancaria(titular, saldo) values( 42999018, 1300000);
insert into cuenta_bancaria(titular, saldo) values( 1023654234, 2700000);

create table historial_transacciones(
    transaccion_id serial PRIMARY KEY ,
	id_cuenta integer  REFERENCES cuenta_bancaria(cuenta_id),
	tipo_transaccion varchar(20) not null,
	valor_transaccion numeric not null,
	fecha_transaccion timestamp not null
);

select * from cuenta_bancaria;
select * from historial_transacciones;