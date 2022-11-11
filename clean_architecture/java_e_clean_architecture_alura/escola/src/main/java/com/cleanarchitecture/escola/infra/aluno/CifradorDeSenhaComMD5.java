package com.cleanarchitecture.escola.infra.aluno;

import com.cleanarchitecture.escola.dominio.aluno.CifradorDeSenha;

public class CifradorDeSenhaComMD5 implements CifradorDeSenha {
    @Override
    public String cifrarSenha(String senha) {
        // lógica de encriptar senha com md5
        return null;
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return false;
    }
}
