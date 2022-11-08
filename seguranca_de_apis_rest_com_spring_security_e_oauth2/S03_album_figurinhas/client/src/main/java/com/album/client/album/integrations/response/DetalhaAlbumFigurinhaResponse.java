package com.album.client.album.integrations.response;

public class DetalhaAlbumFigurinhaResponse {

    private Long id;
    private String descricao;
    private String enderecoDaImagem;

    public DetalhaAlbumFigurinhaResponse() {
    }

    public DetalhaAlbumFigurinhaResponse(Long id, String descricao, String enderecoDaImagem) {
        this.id = id;
        this.descricao = descricao;
        this.enderecoDaImagem = enderecoDaImagem;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEnderecoDaImagem() {
        return enderecoDaImagem;
    }
}
