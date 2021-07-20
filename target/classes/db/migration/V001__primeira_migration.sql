CREATE TABLE empresas(
    id_empresa BIGINT AUTO_INCREMENT NOT NULL,
    nome_empresa VARCHAR(60) NOT NULL,
    email_empresa VARCHAR(60)NOT NULL,
    telefone_empresa VARCHAR(20),
    cidade_empresa VARCHAR(60),
    rua_empresa VARCHAR(60),
    num_empresa VARCHAR(10),
    CONSTRAINT UN_emailempresa UNIQUE(email_empresa),
    CONSTRAINT UN_nomeempresa UNIQUE(nome_empresa),
    CONSTRAINT PK_empresa PRIMARY KEY(id_empresa)
);