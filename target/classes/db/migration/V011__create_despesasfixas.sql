CREATE TABLE despesas_fixas (
    id_despesa_fixa BIGINT AUTO_INCREMENT NOT NULL,
    valor_despesa_fixa NUMERIC(11,2) NOT NULL,
    frequencia_despesa VARCHAR(20) NOT NULL,
    detalhamento_despesa_fixa VARCHAR(60) NOT NULL,
    verif_despesa_fixa BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_DESPESAFIXA PRIMARY KEY(id_despesa_fixa),
    CONSTRAINT FK_EMPRESA_DESPESASFIXAS FOREIGN KEY(id_empresa) REFERENCES empresas(id_empresa)
);