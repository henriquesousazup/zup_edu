package com.album.client.album.response;

import com.album.client.album.integrations.response.DetalhaAlbumFigurinhaResponse;

public class FigurinhaFreemiumResponse {

    private Long id;
    private String descricao;
    private String enderecoDaImagem;

    public FigurinhaFreemiumResponse() {
    }

    public FigurinhaFreemiumResponse(DetalhaAlbumFigurinhaResponse figurinha) {
        this.id = figurinha.getId();
        this.descricao = figurinha.getDescricao();
        this.enderecoDaImagem = figurinha.getEnderecoDaImagem();
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
