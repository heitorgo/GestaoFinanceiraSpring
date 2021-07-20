CREATE TABLE clientes(
    id_cliente BIGINT AUTO_INCREMENT NOT NULL,
    nome_cliente VARCHAR(60) NOT NULL,
    dtanasc_cliente VARCHAR(15) NOT NULL,
    email_cliente VARCHAR(60),
    cpf_cliente  VARCHAR(14) NOT NULL,
    cidade_cliente VARCHAR(60),
    rua_cliente VARCHAR(60),
    bairro_cliente VARCHAR(60),
    numcasa_cliente VARCHAR(10),
    telefone_cliente VARCHAR(20),
    id_empresa BIGINT,
    CONSTRAINT PK_cliente PRIMARY KEY (id_cliente),
    CONSTRAINT FK_empresa_cliente FOREIGN KEY (id_empresa) REFERENCES empresas(id_empresa),
    CONSTRAINT UN_cpfcliente UNIQUE (cpf_cliente, email_cliente)
);