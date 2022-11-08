package com.example.exponenciacao.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExponenciacaoRecursivaTest {

    private ExponenciacaoRecursiva exponenciacaoRecursiva;

    @BeforeEach
    void setUp() {
        exponenciacaoRecursiva = new ExponenciacaoRecursiva();
    }

    @Test
    @DisplayName("Deve retornar 1 caso expoente for 0")
    void test0() {
        assertEquals(1, exponenciacaoRecursiva.exponenciar(10, 0));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(0, 0));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(-10, 0));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(500, 0));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(-500, 0));
    }

    @Test
    @DisplayName("Deve retornar 1 dividido pela base caso o expoente for -1")
    void test1() {
        assertEquals(0.5, exponenciacaoRecursiva.exponenciar(2, -1));
        assertEquals(0.2, exponenciacaoRecursiva.exponenciar(5, -1));
        assertEquals(0.25, exponenciacaoRecursiva.exponenciar(4, -1));
    }

    @Test
    @DisplayName("Deve retornar o valor da base caso expoente for 1")
    void test2() {
        assertEquals(2, exponenciacaoRecursiva.exponenciar(2, 1));
        assertEquals(3, exponenciacaoRecursiva.exponenciar(3, 1));
        assertEquals(500, exponenciacaoRecursiva.exponenciar(500, 1));
        assertEquals(-500, exponenciacaoRecursiva.exponenciar(-500, 1));
        assertEquals(-1, exponenciacaoRecursiva.exponenciar(-1, 1));
        assertEquals(0, exponenciacaoRecursiva.exponenciar(0, 1));
    }

    @Test
    @DisplayName("Deve retornar 1 caso a base for 1")
    void test3() {
        assertEquals(1, exponenciacaoRecursiva.exponenciar(1, 500));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(1, -300));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(1, 1));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(1, 3));
    }

    @Test
    @DisplayName("Deve retornar 1 (expoente par) ou -1 (expoente impar) caso a base for -1")
    void test4() {
        assertEquals(1, exponenciacaoRecursiva.exponenciar(-1, 2));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(-1, 4));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(-1, 400));
        assertEquals(1, exponenciacaoRecursiva.exponenciar(-1, 300));
        assertEquals(-1, exponenciacaoRecursiva.exponenciar(-1, 3));
        assertEquals(-1, exponenciacaoRecursiva.exponenciar(-1, 7));
        assertEquals(-1, exponenciacaoRecursiva.exponenciar(-1, 9));
        assertEquals(-1, exponenciacaoRecursiva.exponenciar(-1, 157));
    }

    @Test
    @DisplayName("Deve retornar resultado menor que 1 caso expoente seja menor que 0")
    void test5() {
        assertThat(exponenciacaoRecursiva.exponenciar(5, -2)).isLessThan(1);
        assertThat(exponenciacaoRecursiva.exponenciar(10, -5)).isLessThan(1);
        assertThat(exponenciacaoRecursiva.exponenciar(40, -7)).isLessThan(1);
        assertThat(exponenciacaoRecursiva.exponenciar(700, -90)).isLessThan(1);
    }

    @Test
    @DisplayName("Deve retornar resultado da exponenciação mesmo que a base for negativa (menor que -1)")
    void test6() {
        // expoente par
        assertEquals(81, exponenciacaoRecursiva.exponenciar(-3d, 4, 1));
        assertEquals(16, exponenciacaoRecursiva.exponenciar(-2d, 4, 1));
        // expoente impar
        assertEquals(-8, exponenciacaoRecursiva.exponenciar(-2d, 3, 1));
        assertEquals(-128, exponenciacaoRecursiva.exponenciar(-2d, 7, 1));
        assertEquals(-1024, exponenciacaoRecursiva.exponenciar(-4d, 5, 1));
    }
}