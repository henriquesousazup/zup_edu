package com.cleanarchitecture.escola.aplicacao.aluno.matricular;

import com.cleanarchitecture.escola.dominio.aluno.Aluno;
import com.cleanarchitecture.escola.dominio.aluno.CPF;
import com.cleanarchitecture.escola.dominio.aluno.RepositorioDeAlunos;
import com.cleanarchitecture.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    @DisplayName("Aluno deverá ser persistido")
    void test0() {

        RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();

        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                "123.456.789-10",
                "henriquesousa@zup.com.br");

        useCase.executa(dados);

        Aluno alunoEncontrado = repositorio.buscarPorCPF(new CPF("123.456.789-10"));

        assertEquals("Fulano", alunoEncontrado.getNome());
        assertEquals("123.456.789-10", alunoEncontrado.getCpf());
        assertEquals("henriquesousa@zup.com.br", alunoEncontrado.getEmail());
    }
}