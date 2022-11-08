CREATE TABLE tb_restaurante (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_fantasia varchar(120) NOT NULL,
    cnpj varchar(14) NOT NULL UNIQUE,
    endereco varchar(140) NOT NULL,
    bairro varchar(120),
    cidade varchar(120),
    cep varchar(9),
    telefone varchar(14),
    celular varchar(14),
    email varchar(200),
    site varchar(255)
);
