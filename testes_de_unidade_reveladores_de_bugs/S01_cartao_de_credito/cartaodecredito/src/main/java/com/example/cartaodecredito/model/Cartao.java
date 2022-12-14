package com.example.cartaodecredito.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Cartao {

    private String numero;

    private String nomeTitular;

    private String codigoSeguranca;

    private String senha;

    private BigDecimal limite;

    private List<Fatura> faturas = new ArrayList<>();

    private LocalDateTime validoAte;

    private final LocalDateTime criadoEm = LocalDateTime.now();

    public Cartao(String numero, String nomeTitular, String codigoSeguranca, String senha, BigDecimal limite, LocalDateTime validoAte) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
        this.senha = senha;
        this.limite = limite;
        this.validoAte = validoAte;
    }

    public boolean isAprovado(Gasto gasto, String codigoSeguranca, String senha) {

        BigDecimal somaDasFaturasFuturas = faturas.stream()
                .filter(fatura -> fatura.getMesAno().compareTo(YearMonth.now()) >= 0)
                .map(Fatura::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal gastosTotais = somaDasFaturasFuturas.add(gasto.getValor());

        return gastosTotais.compareTo(limite) <= 0
                && this.codigoSeguranca.equalsIgnoreCase(codigoSeguranca)
                && this.senha.equalsIgnoreCase(senha);
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }
}

