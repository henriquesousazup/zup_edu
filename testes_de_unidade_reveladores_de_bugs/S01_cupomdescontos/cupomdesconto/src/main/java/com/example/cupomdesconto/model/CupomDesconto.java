package com.example.cupomdesconto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class CupomDesconto {

    private Usuario usuario;
    private Produto produto;
    private BigDecimal porcentagem;
    private LocalDateTime validoAte;

    public CupomDesconto(Usuario usuario, Produto produto, BigDecimal porcentagem, LocalDateTime validoAte) {
        this.usuario = usuario;
        this.produto = produto;
        this.porcentagem = porcentagem;
        this.validoAte = validoAte;
    }

    public boolean isValido() {
        return now().compareTo(validoAte) <= 0;
    }

    public boolean pertence(Usuario usuario) {
        return this.usuario.equals(usuario);
    }

    public boolean pertence(Produto produto) {
        return this.produto.equals(produto);
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }
}