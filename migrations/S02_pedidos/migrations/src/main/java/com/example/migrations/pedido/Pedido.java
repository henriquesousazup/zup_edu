package com.example.migrations.pedido;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private Long estabelecimentoId;

    @CreationTimestamp
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

}
