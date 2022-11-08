package com.album.client.album.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class CadastrarNovoAlbumRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @Size(max = 3)
    @NotEmpty
    private List<CadastrarFigurinhaRequest> figurinhas;

    public CadastrarNovoAlbumRequest(String titulo, String descricao, List<CadastrarFigurinhaRequest> figurinhas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.figurinhas = figurinhas;
    }

    public CadastrarNovoAlbumRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<CadastrarFigurinhaRequest> getFigurinhas() {
        return figurinhas;
    }
}
