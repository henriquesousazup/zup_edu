package com.cleanarchitecture.escola.dominio.aluno;

// VALUE OBJECT
public class Email {

    private String endereco;

    public Email(String endereco) {

        if (endereco == null || !endereco.matches("^[_a-z\\d-]+(\\.[_a-z\\d-]+)*@[a-z\\d-]+(\\.[a-z\\d-]+).(\\.[a-z]{2,3})$")) {
            throw new IllegalArgumentException("Endereço de e-mail inválido");
        }

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
