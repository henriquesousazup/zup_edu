package com.zupedu.credito.oferta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Tipo tipo;

    private int agencia;

    private long numero;

    private BigDecimal valor;

    @Deprecated
    public Oferta() {
    }

    public Oferta(Tipo tipo, int agencia, long numero, BigDecimal valor) {
        this.tipo = tipo;
        this.agencia = agencia;
        this.numero = numero;
        this.valor = valor;
    }
}
