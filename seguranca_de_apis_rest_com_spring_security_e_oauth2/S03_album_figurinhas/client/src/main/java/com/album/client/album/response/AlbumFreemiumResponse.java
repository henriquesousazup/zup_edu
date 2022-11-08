package com.album.client.album.response;

import com.album.client.album.integrations.response.DetalhaAlbumResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumFreemiumResponse {

    private String planoContratado;
    private Long id;
    private String titulo;
    private String descricao;
    private String dono;
    private List<FigurinhaFreemiumResponse> figurinhas;

    public AlbumFreemiumResponse(DetalhaAlbumResponse album) {
        this.planoContratado = Plano.FREEMIUM.name();
        this.id = album.getId();
        this.titulo = album.getTitulo();
        this.descricao = album.getDescricao();
        this.dono = album.getDono();
        this.figurinhas = album.getFigurinhas().stream().map(FigurinhaFreemiumResponse::new).collect(Collectors.toList());
    }

    public AlbumFreemiumResponse() {
    }

    public String getPlanoContratado() {
        return planoContratado;
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

    public List<FigurinhaFreemiumResponse> getFigurinhas() {
        return figurinhas;
    }
}
