CREATE TABLE DESPESAS(
    IDDESPESA BIGINT AUTO_INCREMENT NOT NULL,
    VALORDESPESA NUMERIC(11,2) NOT NULL,
    DATADESPESA VARCHAR(15) NOT NULL,
    DETALHAMENTODESPESA VARCHAR(60) NOT NULL,
    VERIFDESPESA BOOLEAN,
    IDEMPRESA BIGINT,	
    CONSTRAINT PK_DESPESA PRIMARY KEY(IDDESPESA),
    CONSTRAINT FK_EMPRESA_DESPESAS FOREIGN KEY(IDEMPRESA) REFERENCES empresas(IDEMPRESA)
);