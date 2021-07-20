CREATE TABLE vendas(
    id_venda BIGINT AUTO_INCREMENT NOT NULL,
    valor_venda NUMERIC(11,2) NOT NULL,
    data_venda VARCHAR(15) NOT NULL,
    detalhamento_venda VARCHAR(60) NOT NULL,
    verif_venda BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_VENDA PRIMARY KEY(id_venda),
    CONSTRAINT FK_EMPRESA_VENDAS FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
); 