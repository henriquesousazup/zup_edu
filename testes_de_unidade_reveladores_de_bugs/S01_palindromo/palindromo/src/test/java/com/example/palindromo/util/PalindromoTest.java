package com.example.palindromo.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PalindromoTest {

    private Palindromo palindromo;

    @BeforeEach
    void setUp() {
        palindromo = new Palindromo();
    }

    // 1ª BRANCH
    /**
     *     if (palavra == null || palavra.isBlank()) {
     *             return false;
     *      }
     */
    @ParameterizedTest(
            name = "{index}=>entrada={0}"
    )
    @MethodSource("primeiraBranchMcdc")
    void structuralTestFuncaoPublica(String entrada) {
        assertFalse(palindromo.isPalindromo(entrada));
    }

    /**
     * 2 - Palavra nula -> A(2)
     * 3 - Palavra em branco -> B(3)
     * 4 - Palavra válida -> A(4) B(4)
     */
    private static Stream<Arguments> primeiraBranchMcdc() {
        return Stream.of(
                // 3
                Arguments.of(""),
                // 4
                Arguments.of("valido")
        );
    }

    // 1
    @Test
    @DisplayName("deve retornar false caso uma palavra seja valor nulo")
    void test4() {
        String palavra = null;
        assertFalse(palindromo.isPalindromo(palavra));
    }


    // 2ª BRANCH
    /**
     *
     * if (indexDaPontaDireitaDoArray > 0 && letraAtualDaPontaEsquerda == letraAtualDaPontaDireita) {
     *    return isPalindromoRecursive(palavra, indexDaPontaEsquerdaDoArray + 1, indexDaPontaDireitaDoArray - 1);
     * }
     *
     */
    @ParameterizedTest(
            name = "{index}=>entrada={0}, resultado={1}"
    )
    @MethodSource("segundaBranchMcdc")
    void structuralTestFuncaoPrivada(String entrada, boolean resultado) {
        assertEquals(resultado,palindromo.isPalindromo(entrada));
    }

    /**
     * 1 -> Index da ponta direita do array MAIOR que zero e letra da ponta esquerda IGUAL à letra da ponta direita -> A(1) B(1)
     * 2 -> Index da ponta direita do array MAIOR que zero e letra da ponta esquerda DIFERENTE da letra da ponta direita -> B(2)
     * 3 -> Index da ponta direita do array MENOR ou IGUAL a zero e letra da ponta esquerda IGUAL à letra da ponta direita -> A(3)
     */
    private static Stream<Arguments> segundaBranchMcdc() {
        return Stream.of(
                // 1
                Arguments.of("ovo",true),
                Arguments.of("Socorram-me subi no onibus em Marrocos",true),
                Arguments.of("ána",true),
                // 2
                Arguments.of("ane",false),
                Arguments.of("raf",false),
                // 3
                Arguments.of("o",true)
        );
    }
}


//    @Test
//    @DisplayName("deve retornar true caso uma palavra seja palindromo")
//    void test1() {
//        String palavra = "arara";
//        assertTrue(palindromo.isPalindromo(palavra));
//    }
//
//    @Test
//    @DisplayName("deve retornar true caso uma frase com acentuação seja palindromo")
//    void test2() {
//        String frase = "Me vê se a panela da moça é de aço, Madalena Paes, e vem";
//        assertTrue(palindromo.isPalindromo(frase));
//    }
//
//    @Test
//    @DisplayName("deve retornar false caso não seja uma palavra palindromo")
//    void test3() {
//        String palavra = "Rato";
//        assertFalse(palindromo.isPalindromo(palavra));
//    }
//
//    @Test
//    @DisplayName("deve retornar false caso uma palavra seja valor nulo")
//    void test4() {
//        String palavra = null;
//        assertFalse(palindromo.isPalindromo(palavra));
//    }
//
//    @Test
//    @DisplayName("deve retornar false caso uma palavra seja valor branco")
//    void test5() {
//        String palavra = "";
//        assertFalse(palindromo.isPalindromo(palavra));
//    }
