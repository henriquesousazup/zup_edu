package com.example.cupomdesconto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProdutoTest {

    private Produto mochila;
    private Produto caderno;
    private Usuario henrique;
    private Usuario jordi;

    @BeforeEach
    void setUp() {
        mochila = new Produto("Mochila", new BigDecimal("100"));
        caderno = new Produto("Caderno", new BigDecimal("50"));

        henrique = new Usuario("Henrique", "henrique.desousa@zup.com.br");
        jordi = new Usuario("Jordi", "jordi@zup.com.br");
    }

    @Test
    @DisplayName("Usuário deve receber desconto na compra do produto")
    void test0() {
        // utilizando in point na data (Boundery Test) válido até hoje
        CupomDesconto cupom = new CupomDesconto(henrique, mochila, new BigDecimal("0.3"), LocalDateTime.now());

        Compra compra = mochila.comprar(cupom, henrique);
        BigDecimal valorEsperado = new BigDecimal("70.0");

        assertEquals(valorEsperado, compra.getValor());
    }

    @Test
    @DisplayName("Usuário não deve receber desconto na compra do produto caso o cupom não for válido")
    void test1() {
        // utilizando off point na data (Boundery Test) válido até 1 segundo atrás
        CupomDesconto cupom = new CupomDesconto(henrique, mochila, new BigDecimal("0.3"), LocalDateTime.now().minusSeconds(1));

        Compra compra = mochila.comprar(cupom, henrique);

        assertEquals(mochila.getPreco(), compra.getValor());
    }

    @Test
    @DisplayName("Usuário não deve receber desconto caso cupom seja válido, mas não pertença a ele")
    void test2() {
        // utilizando um dos in points na data (Boundery Test) válido até daqui a 1 segundo
        CupomDesconto cupom = new CupomDesconto(jordi, mochila, new BigDecimal("0.3"), LocalDateTime.now().plusSeconds(1));

        Compra compra = mochila.comprar(cupom, henrique);

        assertEquals(mochila.getPreco(), compra.getValor());
    }

    @Test
    @DisplayName("Usuário não deve receber desconto caso cupom seja válido, mas não pertença ao produto de compra")
    void test3() {
        // utilizando um dos in points na data (Boundery Test) válido daqui até 2 segundos
        CupomDesconto cupom = new CupomDesconto(henrique, mochila, new BigDecimal("0.3"), LocalDateTime.now().plusSeconds(2));

        Compra compra = caderno.comprar(cupom, henrique);

        assertEquals(caderno.getPreco(), compra.getValor());
    }
}