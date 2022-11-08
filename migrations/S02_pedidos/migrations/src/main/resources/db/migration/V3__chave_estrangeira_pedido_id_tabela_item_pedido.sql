ALTER TABLE item_pedido
ADD CONSTRAINT fk_pedido_id_item_pedido
FOREIGN KEY (pedido_id) REFERENCES pedido(id);