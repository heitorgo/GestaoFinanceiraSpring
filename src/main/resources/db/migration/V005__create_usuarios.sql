CREATE TABLE usuarios(
    id_usuario BIGINT AUTO_INCREMENT NOT NULL,
    email_usuario VARCHAR(60)NOT NULL,
    senha_usuario VARCHAR(60)NOT NULL,
    CONSTRAINT UN_email_usuario UNIQUE(email_usuario),
    CONSTRAINT UN_senha UNIQUE(senha_usuario),
    CONSTRAINT PK_usuario PRIMARY KEY(id_usuario)
);