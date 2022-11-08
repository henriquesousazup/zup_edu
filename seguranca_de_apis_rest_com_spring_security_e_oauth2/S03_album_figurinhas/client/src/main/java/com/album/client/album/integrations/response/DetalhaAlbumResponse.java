package com.album.client.album.integrations.response;

import java.util.List;

public class DetalhaAlbumResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String dono;
    private List<DetalhaAlbumFigurinhaResponse> figurinhas;

    public DetalhaAlbumResponse() {
    }

    public DetalhaAlbumResponse(Long id, String titulo, String descricao, String dono, List<DetalhaAlbumFigurinhaResponse> figurinhas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dono = dono;
        this.figurinhas = figurinhas;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDono() {
        return dono;
    }

    public List<DetalhaAlbumFigurinhaResponse> getFigurinhas() {
        return figurinhas;
    }
}
