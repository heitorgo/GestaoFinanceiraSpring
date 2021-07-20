CREATE TABLE contas_receber (
    id_receber BIGINT AUTO_INCREMENT NOT NULL,
    valor_receber NUMERIC(11,2) NOT NULL,
    data_receber VARCHAR(15) NOT NULL,
    detalhamento_receber VARCHAR(60) NOT NULL,
    verif_receber BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_RECEBER PRIMARY KEY(id_receber),
    CONSTRAINT FK_EMPRESA_CONTASRECEBER FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
);