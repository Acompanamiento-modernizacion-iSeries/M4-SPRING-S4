-- Table: public.cuenta

-- DROP TABLE IF EXISTS public.cuenta;

CREATE TABLE IF NOT EXISTS public.cuenta
(
    id integer NOT NULL DEFAULT nextval('cuenta_id_seq'::regclass),
    titular character varying(255) COLLATE pg_catalog."default",
    saldo numeric(19,2) NOT NULL,
    CONSTRAINT cuenta_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cuenta
    OWNER to postgres;


-- Table: public.transaccion

-- DROP TABLE IF EXISTS public.transaccion;

CREATE TABLE IF NOT EXISTS public.transaccion
(
    id integer NOT NULL DEFAULT nextval('transaccion_id_seq'::regclass),
    tipo character varying(255) COLLATE pg_catalog."default" NOT NULL,
    monto numeric(10,2) NOT NULL,
    cuenta_id bigint,
    CONSTRAINT transaccion_pkey PRIMARY KEY (id),
    CONSTRAINT transaccion_cuenta_id_fkey FOREIGN KEY (cuenta_id)
        REFERENCES public.cuenta (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaccion
    OWNER to postgres;

-- Inserts

INSERT INTO cuenta (saldo, titular)
VALUES
  (0.00, 'Juan Pérez'),
  (0.00, 'María Rodríguez'),
  (0.00, 'Carlos Sánchez'),
  (0.00, 'Ana García'),
  (0.00, 'Pedro Martínez'),
  (0.00, 'Laura López'),
  (0.00, 'Daniel Hernández'),
  (0.00, 'Sofia Jiménez'),
  (0.00, 'Diego Moreno'),
  (0.00, 'Valentina Guzmán');