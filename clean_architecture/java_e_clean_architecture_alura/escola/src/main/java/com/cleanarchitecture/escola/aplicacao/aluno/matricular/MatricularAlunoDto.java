package com.cleanarchitecture.escola.aplicacao.aluno.matricular;

import com.cleanarchitecture.escola.dominio.aluno.Aluno;
import com.cleanarchitecture.escola.dominio.aluno.CPF;
import com.cleanarchitecture.escola.dominio.aluno.Email;

public class MatricularAlunoDto {

    private String nome;
    private String cpf;
    private String email;

    public MatricularAlunoDto(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Aluno toModel() {
        return new Aluno(new CPF(cpf), nome, new Email(email));
    }
}
