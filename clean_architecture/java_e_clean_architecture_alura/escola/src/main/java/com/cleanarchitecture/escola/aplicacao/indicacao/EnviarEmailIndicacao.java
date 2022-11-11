package com.cleanarchitecture.escola.aplicacao.indicacao;

import com.cleanarchitecture.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
