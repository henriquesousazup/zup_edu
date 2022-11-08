package com.livraria.client.exposicao.response;

import com.livraria.client.exposicao.integrations.response.AutorResponse;
import com.livraria.client.exposicao.integrations.response.LivroResponse;

import java.time.LocalDate;

public class LivroExposicaoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private String isbn;
    private LocalDate publicadoEm;
    private AutorExposicaoResponse autor;

    public LivroExposicaoResponse(LivroResponse livroResponse, AutorResponse autorResponse) {
        this.id = livroResponse.getId();
        this.nome = livroResponse.getNome();
        this.descricao = livroResponse.getDescricao();
        this.isbn = livroResponse.getIsbn();
        this.publicadoEm = livroResponse.getPublicadoEm();
        this.autor = new AutorExposicaoResponse(autorResponse);
    }

    public LivroExposicaoResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicadoEm() {
        return publicadoEm;
    }

    public AutorExposicaoResponse getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "LivroExposicaoResponse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicadoEm=" + publicadoEm +
                ", autor=" + autor +
                '}';
    }
}
