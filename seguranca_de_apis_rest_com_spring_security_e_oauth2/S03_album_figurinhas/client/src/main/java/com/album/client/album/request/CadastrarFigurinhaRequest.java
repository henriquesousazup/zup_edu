package com.album.client.album.request;

public class CadastrarFigurinhaRequest {

    private String descricao;
    private String enderecoDaImagem;

    public CadastrarFigurinhaRequest(String descricao, String enderecoDaImagem) {
        this.descricao = descricao;
        this.enderecoDaImagem = enderecoDaImagem;
    }

    public CadastrarFigurinhaRequest() {
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEnderecoDaImagem() {
        return enderecoDaImagem;
    }
}
