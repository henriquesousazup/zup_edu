package com.example.migrations.pedido;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;

    private BigDecimal valor;

    private Integer quantidade;

    @ManyToOne
    private Pedido pedido;

}
