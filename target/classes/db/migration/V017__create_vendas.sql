CREATE TABLE VENDAS(
    IDVENDA BIGINT AUTO_INCREMENT NOT NULL,
    VALORVENDA NUMERIC(11,2) NOT NULL,
    DATAVENDA VARCHAR(15) NOT NULL,
    DETALHAMENTOVENDA VARCHAR(60) NOT NULL,
    VERIFVENDA BOOLEAN,
    IDEMPRESA BIGINT,	
    CONSTRAINT PK_VENDA PRIMARY KEY(IDVENDA),
    CONSTRAINT FK_EMPRESA_VENDAS FOREIGN KEY(IDEMPRESA) REFERENCES empresas(IDEMPRESA)
); 