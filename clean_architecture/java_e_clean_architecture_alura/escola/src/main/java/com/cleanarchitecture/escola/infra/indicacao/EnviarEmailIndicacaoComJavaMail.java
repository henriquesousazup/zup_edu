package com.cleanarchitecture.escola.infra.indicacao;

import com.cleanarchitecture.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import com.cleanarchitecture.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        // lógica de envio de email com JavaMail
    }

}
