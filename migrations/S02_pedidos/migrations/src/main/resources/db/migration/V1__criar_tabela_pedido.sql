CREATE TABLE pedido (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cliente_id bigint NOT NULL,
    estabelecimento_id bigint NOT NULL,
    data_pedido timestamp
);