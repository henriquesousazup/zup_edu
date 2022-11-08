package com.livraria.client.exposicao.response;

import com.livraria.client.exposicao.integrations.response.AutorResponse;

public class AutorExposicaoResponse {

    private String nome;
    private String email;

    public AutorExposicaoResponse(AutorResponse autorResponse) {
        this.nome = autorResponse.getNome();
        this.email = autorResponse.getEmail();
    }

    public AutorExposicaoResponse() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "AutorExposicaoResponse{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
