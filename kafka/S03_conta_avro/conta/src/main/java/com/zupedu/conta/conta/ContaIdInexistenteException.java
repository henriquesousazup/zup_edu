package com.zupedu.conta.conta;

public class ContaIdInexistenteException extends RuntimeException{

    public ContaIdInexistenteException() {
        super("Não existe conta com esse ID");
    }
}
