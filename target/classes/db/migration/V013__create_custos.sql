CREATE TABLE custos(
    id_custo BIGINT AUTO_INCREMENT NOT NULL,
    valor_custo NUMERIC(11,2) NOT NULL,
    data_custo VARCHAR(15) NOT NULL,
    detalhamento_custo VARCHAR(60) NOT NULL,
    verif_custo BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_CUSTO PRIMARY KEY(id_custo),
    CONSTRAINT FK_EMPRESA_CUSTOS FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
);