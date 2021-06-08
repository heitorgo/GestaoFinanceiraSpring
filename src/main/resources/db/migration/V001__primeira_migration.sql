CREATE TABLE EMPRESAS(
    IDEMPRESA BIGINT NOT NULL,
    NOMEEMPRESA VARCHAR(60) NOT NULL,
    EMAILEMPRESA VARCHAR(60)NOT NULL,
    CONTATOEMPRESA VARCHAR(20),
    CIDADEEMPRESA VARCHAR(60),
    RUAEMPRESA VARCHAR(60),
    NUMEMPRESA VARCHAR(10),
    CONSTRAINT UN_EMAILEMPRESA UNIQUE(EMAILEMPRESA),
    CONSTRAINT UN_NOME UNIQUE(NOMEEMPRESA),
    CONSTRAINT PK_EMPRESA PRIMARY KEY(IDEMPRESA)
);