package com.cleanarchitecture.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno nao encontrado com Email: " + cpf.getNumero());
    }

}
