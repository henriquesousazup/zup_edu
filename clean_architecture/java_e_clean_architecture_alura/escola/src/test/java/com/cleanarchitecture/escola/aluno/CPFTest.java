package com.cleanarchitecture.escola.aluno;

import com.cleanarchitecture.escola.dominio.aluno.CPF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    @DisplayName("Não deve criar um CPF inválido")
    void test0() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF("12345678910"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123.456.789-101"));
    }

    @Test
    @DisplayName("Deve criar um CPF")
    void test1() {
        String numeroValido = "596.955.990-36";
        CPF cpfValido = new CPF(numeroValido);

        assertEquals(numeroValido, cpfValido.getNumero());
    }

}