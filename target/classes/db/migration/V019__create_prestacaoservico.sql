CREATE TABLE prestacao_servicos(
    id_servico BIGINT AUTO_INCREMENT NOT NULL,
    valor_servico NUMERIC(11,2) NOT NULL,
    data_servico VARCHAR(15) NOT NULL,
    detalhamento_servico VARCHAR(60) NOT NULL,
    verif_servico BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_SERVICO PRIMARY KEY(id_servico),
    CONSTRAINT FK_EMPRESA_PESTACAOSERVICO FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
);