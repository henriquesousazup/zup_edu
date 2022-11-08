package com.example.cupomdesconto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CupomDescontoTest {

    private Produto caderno;
    private Usuario henrique;

    @BeforeEach
    void setUp() {
        caderno = new Produto("Caderno", new BigDecimal("50"));
        henrique = new Usuario("Henrique", "henrique.desousa@zup.com.br");
    }

    @Test
    @DisplayName("Cupom deve estar na data de validade")
    void test0() {
        // Boundery Test -> Limite de data de expiração (agora)
        CupomDesconto cupomValido = new CupomDesconto(henrique, caderno, new BigDecimal("0.5"), LocalDateTime.now());

        assertTrue(cupomValido.isValido());
    }

    @Test
    @DisplayName("Cupom não deve estar na data de validade")
    void test1() {
        // Boundery Test -> Off point de data de expiração próxima ao limite (agora menos 1 segundo)
        CupomDesconto cupomValido = new CupomDesconto(henrique, caderno, new BigDecimal("0.5"), LocalDateTime.now().minusSeconds(1));

        assertFalse(cupomValido.isValido());
    }

    @Test
    @DisplayName("Cupom deve estar na data de validade, faltando 1 segundo para a data limite")
    void test2() {
        // Boundery Test -> Limite de data de expiração (agora + 1 segundo)
        CupomDesconto cupomValido = new CupomDesconto(henrique, caderno, new BigDecimal("0.5"), LocalDateTime.now().plusSeconds(1));

        assertTrue(cupomValido.isValido());
    }
}