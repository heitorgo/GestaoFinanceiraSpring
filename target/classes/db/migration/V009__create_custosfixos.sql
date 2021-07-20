CREATE TABLE custos_fixos (
    id_custo_fixo BIGINT AUTO_INCREMENT NOT NULL,
    valor_custo_fixo NUMERIC(11,2) NOT NULL,
    frequencia_custo VARCHAR(20) NOT NULL,
    detalhamento_custo_fixo VARCHAR(60) NOT NULL,
    verif_custo_fixo BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_CUSTOFIXO PRIMARY KEY(id_custo_fixo),
    CONSTRAINT FK_EMPRESA_CUSTOSFIXOS FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
);
