package com.cleanarchitecture.escola.aplicacao.aluno.matricular;

import com.cleanarchitecture.escola.dominio.aluno.Aluno;
import com.cleanarchitecture.escola.dominio.aluno.RepositorioDeAlunos;

//Use Case - Application Service - Command Handler
public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    // PADRÃO COMMAND
    public void executa(MatricularAlunoDto matricularAluno) {
        Aluno aluno = matricularAluno.toModel();
        repositorio.matricular(aluno);
    }

}
