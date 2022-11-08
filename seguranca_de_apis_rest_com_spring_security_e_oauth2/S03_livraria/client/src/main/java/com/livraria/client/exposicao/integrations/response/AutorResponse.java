package com.livraria.client.exposicao.integrations.response;

import java.time.LocalDateTime;
import java.util.List;

public class AutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime criadoEm;
    private List<LivroResponse> livros;

    public AutorResponse(Long id, String nome, String email, String descricao, LocalDateTime criadoEm, List<LivroResponse> livros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.criadoEm = criadoEm;
        this.livros = livros;
    }

    public AutorResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public List<LivroResponse> getLivros() {
        return livros;
    }

}
