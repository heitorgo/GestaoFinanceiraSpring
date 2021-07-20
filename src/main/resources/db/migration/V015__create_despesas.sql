CREATE TABLE despesas(
    id_despesa BIGINT AUTO_INCREMENT NOT NULL,
    valor_despesa NUMERIC(11,2) NOT NULL,
    data_despesa VARCHAR(15) NOT NULL,
    detalhamento_despesa VARCHAR(60) NOT NULL,
    verif_despesa BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_DESPESA PRIMARY KEY(id_despesa),
    CONSTRAINT FK_EMPRESA_DESPESAS FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
);