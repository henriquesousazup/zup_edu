package com.cleanarchitecture.escola.aluno;

import com.cleanarchitecture.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    @DisplayName("Não deve criar um telefone com ddd ou/e numero inválidos")
    void test0() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("11", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "1234567"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("123", "1234567891"));
    }

    @Test
    @DisplayName("Deve criar um telefone")
    void test1() {
        String ddd = "11";
        String numero9Digitos = "912345678";
        String numero8Digitos = "12345678";

        Telefone telefone8Digitos = new Telefone(ddd, numero8Digitos);
        Telefone telefone9Digitos = new Telefone(ddd, numero9Digitos);

        assertEquals(ddd, telefone8Digitos.getDdd());
        assertEquals(numero8Digitos, telefone8Digitos.getNumero());

        assertEquals(ddd, telefone9Digitos.getDdd());
        assertEquals(numero9Digitos, telefone9Digitos.getNumero());
    }
}