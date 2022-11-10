package com.cleanarchitecture.escola.dominio.aluno;

// VALUE OBJECT
public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {

        if(ddd == null || !ddd.matches("\\d{2}")){
             throw new IllegalArgumentException ("DDD do telefone é inválido!");
        }

        if(numero == null || !numero.matches("\\d{8}|\\d{9}")){
            throw new IllegalArgumentException ("Número do telefone é inválido!");
        }

        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
