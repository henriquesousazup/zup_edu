package com.example.cartaodecredito.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CartaoTest {

    private Cartao cartao;
    private Cartao cartaoFaturaMesesAnteriores;
    private Fatura faturaAtual;
    private Fatura faturaMesAnterior;
    private Fatura faturaMesQueVem;

    @BeforeEach
    void setUp() {
        cartao = new Cartao("12345",
                "Henrique",
                "123",
                "1234",
                new BigDecimal("2000"),
                LocalDateTime.now().plusYears(4));

        Gasto g1 = new Gasto(new BigDecimal("40"));
        Gasto g2 = new Gasto(new BigDecimal("40"));
        Gasto g3 = new Gasto(new BigDecimal("10"));
        Gasto g4 = new Gasto(new BigDecimal("10"));

        faturaAtual = new Fatura(cartao, YearMonth.now().plusMonths(1));
        faturaAtual.adicionar(g1);
        faturaAtual.adicionar(g2);
        faturaAtual.adicionar(g3);

        faturaMesQueVem = new Fatura(cartao, YearMonth.now().plusMonths(2));
        faturaMesQueVem.adicionar(g4);

        cartao.setFaturas(Arrays.asList(faturaAtual, faturaMesQueVem));

        cartaoFaturaMesesAnteriores = new Cartao("12345",
                "Henrique",
                "123",
                "1234",
                new BigDecimal("100"),
                LocalDateTime.now().plusYears(4));

        faturaMesAnterior = new Fatura(cartao, YearMonth.now().minusMonths(1));
        faturaMesAnterior.adicionar(g1);
        faturaMesAnterior.adicionar(g2);
        faturaMesAnterior.adicionar(g3);
        faturaMesAnterior.adicionar(g4);

        cartaoFaturaMesesAnteriores.setFaturas(Arrays.asList(faturaMesAnterior));
    }

    @Test
    @DisplayName("Cartão deve ser aprovado")
    void test0() {
        // Usando Boundery Test -> Gasto atual + Faturas futuras == Limite
        Gasto gastoAtualValido = new Gasto(new BigDecimal("1900"));
        assertTrue(cartao.isAprovado(gastoAtualValido, "123", "1234"));
    }

    @Test
    @DisplayName("Cartão deve ser aprovado utilizando valor (próximo) menor que o limite")
    void test1() {
        // Usando Boundery Test -> Gasto atual + Faturas futuras == Limite - 1
        Gasto gastoAtualValido = new Gasto(new BigDecimal("1899"));
        assertTrue(cartao.isAprovado(gastoAtualValido, "123", "1234"));
    }

    @Test
    @DisplayName("Cartão não deve ser aprovado utilizando valor (próximo) maior que o limite")
    void test2() {
        // Usando Boundery Test -> Gasto atual + Faturas futuras == Limite + 1
        Gasto gastoAtualInvalido = new Gasto(new BigDecimal("1901"));
        assertFalse(cartao.isAprovado(gastoAtualInvalido, "123", "1234"));
    }

    @Test
    @DisplayName("Cartão não deve ser aprovado caso senha esteja incorreta")
    void test3() {
        Gasto gastoAtualValido = new Gasto(new BigDecimal("20"));
        assertFalse(cartao.isAprovado(gastoAtualValido, "123", "345892"));
    }

    @Test
    @DisplayName("Cartão não deve ser aprovado caso código de segurança esteja incorreto")
    void test4() {
        Gasto gastoAtualValido = new Gasto(new BigDecimal("20"));
        assertFalse(cartao.isAprovado(gastoAtualValido, "345", "1234"));
    }

    @Test
    @DisplayName("Cartão não deve ser aprovado caso gasto atual somado com as faturas futuras sejam maior que o limite")
    void test5() {
        Gasto gastoAtualInvalido = new Gasto(new BigDecimal("1920"));
        assertFalse(cartao.isAprovado(gastoAtualInvalido, "123", "1234"));
    }

    @Test
    @DisplayName("Cartão deve ser aprovado caso só tenha gastos de meses anteriores")
    void test6() {
        Gasto gastoAtualMenorQueLimite = new Gasto(new BigDecimal("100"));
        assertFalse(cartaoFaturaMesesAnteriores.isAprovado(gastoAtualMenorQueLimite, "345", "1234"));
    }
}