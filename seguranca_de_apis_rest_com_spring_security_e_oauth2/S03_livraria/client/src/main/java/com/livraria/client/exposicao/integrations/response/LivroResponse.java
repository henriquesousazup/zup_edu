package com.livraria.client.exposicao.integrations.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LivroResponse {

    private Long id;
    private String nome;
    private String descricao;
    private String isbn;
    private Long autorId;
    private LocalDate publicadoEm;
    private LocalDateTime criadoEm;

    public LivroResponse(Long id, String nome, String descricao, String isbn, Long autorId, LocalDate publicadoEm, LocalDateTime criadoEm) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.isbn = isbn;
        this.autorId = autorId;
        this.publicadoEm = publicadoEm;
        this.criadoEm = criadoEm;
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

    public Long getAutorId() {
        return autorId;
    }

    public LocalDate getPublicadoEm() {
        return publicadoEm;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return "LivroResponse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autorId=" + autorId +
                ", publicadoEm=" + publicadoEm +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
