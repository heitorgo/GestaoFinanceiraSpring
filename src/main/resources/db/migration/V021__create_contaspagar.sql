CREATE TABLE contas_pagar(
    id_pagar BIGINT AUTO_INCREMENT NOT NULL,
    valor_pagar NUMERIC(11,2) NOT NULL,
    data_pagar VARCHAR(15) NOT NULL,
    detalhamento_pagar VARCHAR(60) NOT NULL,
    verif_pagar BOOLEAN,
    id_empresa BIGINT,	
    CONSTRAINT PK_PAGAR PRIMARY KEY (id_pagar),
    CONSTRAINT FK_EMPRESA_CONTASPAGAR  FOREIGN KEY (id_empresa) REFERENCES empresas(id_empresa) 
);