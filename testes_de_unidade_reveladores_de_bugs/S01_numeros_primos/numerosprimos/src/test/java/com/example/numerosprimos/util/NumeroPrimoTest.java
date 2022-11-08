package com.example.numerosprimos.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumeroPrimoTest {

    private NumeroPrimo numeroPrimo;

    @BeforeEach
    void setUp() {
        numeroPrimo = new NumeroPrimo();
    }

    @ParameterizedTest(
            name = "{index}=>numero={0}, resultado={1}"
    )
    @MethodSource("primeiraBranchMcdc")
    void structuralTestPrimeiraBranch(int numero, boolean resultado) {
        assertEquals(resultado, numeroPrimo.primo(numero));
    }

    @ParameterizedTest(
            name = "{index}=>numero={0}, resultado={1}"
    )
    @MethodSource("segundaBranchMcdc")
    void structuralTestSegundaBranch(int numeroInicial, int numeroVariavel, boolean resultado) {
        assertEquals(resultado, numeroPrimo.primo(numeroInicial, numeroVariavel, 0));
    }

    @ParameterizedTest(
            name = "{index}=>numero={0}, resultado={1}"
    )
    @MethodSource("terceiraBranchMcdc")
    void structuralTestTerceiraBranch(int numeroInicial, int numeroVariavel, boolean resultado) {
        assertEquals(resultado, numeroPrimo.primo(numeroInicial, numeroVariavel, 0));
    }

    @ParameterizedTest(
            name = "{index}=>numero={0}, resultado={1}"
    )
    @MethodSource("quartaBranchMcdc")
    void structuralTestQuartaBranch(int numeroInicial, int numeroVariavel, boolean resultado) {
        assertEquals(resultado, numeroPrimo.primo(numeroInicial, numeroVariavel, 0));
    }

    private static Stream<Arguments> primeiraBranchMcdc() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(1, false),
                Arguments.of(2, true)
        );
    }

    private static Stream<Arguments> segundaBranchMcdc() {
        return Stream.of(
                Arguments.of(6, 2, false),
                Arguments.of(2, 1, true),
                Arguments.of(2, 2, false),
                Arguments.of(6, 6, false)
        );
    }

    private static Stream<Arguments> terceiraBranchMcdc() {
        return Stream.of(
                Arguments.of(6, 5, false),
                Arguments.of(7, 10, false),
                Arguments.of(5, 5, false),
                Arguments.of(5, 3, false),
                Arguments.of(5, 1, true)
        );
    }

    private static Stream<Arguments> quartaBranchMcdc() {
        return Stream.of(
                Arguments.of(2, 1, true),
                Arguments.of(7, 1, true),
                Arguments.of(13, 1, true),
                Arguments.of(347, 1, true),
                Arguments.of(4, 3, false),
                Arguments.of(4, 4, false)
        );
    }
}