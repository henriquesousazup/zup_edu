CREATE TABLE item_pedido (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(20) NOT NULL,
    valor float NOT NULL,
    quantidade NUMERIC NOT NULL,
    pedido_id bigint NOT NULL
);