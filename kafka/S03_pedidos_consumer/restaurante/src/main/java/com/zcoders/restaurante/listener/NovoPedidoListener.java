package com.zcoders.restaurante.listener;

import com.zcoders.restaurante.model.Item;
import com.zcoders.restaurante.model.Pedido;
import com.zcoders.restaurante.model.StatusPedido;
import com.zcoders.restaurante.repository.ItemRepository;
import com.zcoders.restaurante.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NovoPedidoListener {

    Logger logger = LoggerFactory.getLogger(NovoPedidoListener.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemRepository itemRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.novo-pedido}")
    public void recebe(NovoPedidoEvent novoPedidoEvent) {

        Pedido pedido = new Pedido(
                novoPedidoEvent.getId(),
                novoPedidoEvent.getIdCliente(),
                novoPedidoEvent.getIdRestaurante(),
                novoPedidoEvent.getDataCriado(),
                StatusPedido.valueOf(novoPedidoEvent.getStatus().toString())
        );

        pedidoRepository.save(pedido);

        List<Item> itens = novoPedidoEvent.getItens()
                .stream().map(i -> new Item(i.getId(), i.getQuantidade(),
                        i.getSku(), (BigDecimal) i.getValor(),
                        i.getDataCriado())).collect(Collectors.toList());

        itemRepository.saveAll(itens);

        logger.info("Evento lido com sucesso idCompra: {}", novoPedidoEvent.toString());
    }
}
