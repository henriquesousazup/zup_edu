package com.cleanarchitecture.escola.aluno;

import com.cleanarchitecture.escola.dominio.aluno.Email;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    @DisplayName("não deve criar email com endereco inválido")
    void test0() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailInvalido@"));
    }

    @Test
    @DisplayName("deve criar email válido")
    void test1() {
        String emailValido = "henriquesousa@zup.com.br";
        Email email = new Email(emailValido);

        assertEquals(emailValido, email.getEndereco());
    }
}