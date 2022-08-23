CREATE TABLE cliente  (
	id int8 NOT NULL,
	nome varchar(150) NOT NULL,
	data_nascimento date NOT NULL,
	cpf varchar(11) NOT NULL,
	endereco varchar(250),
	sexo char(1),
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE public.cliente_id_seq INCREMENT 1 START 11 MINVALUE 1;