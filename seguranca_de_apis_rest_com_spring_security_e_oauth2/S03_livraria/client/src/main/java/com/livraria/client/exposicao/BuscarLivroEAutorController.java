package com.livraria.client.exposicao;

import com.livraria.client.exposicao.integrations.AutorClient;
import com.livraria.client.exposicao.integrations.LivroClient;
import com.livraria.client.exposicao.integrations.response.AutorResponse;
import com.livraria.client.exposicao.integrations.response.LivroResponse;
import com.livraria.client.exposicao.response.LivroExposicaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BuscarLivroEAutorController {

    private final LivroClient livroClient;
    private final AutorClient autorClient;

    public BuscarLivroEAutorController(LivroClient livroClient, AutorClient autorClient) {
        this.livroClient = livroClient;
        this.autorClient = autorClient;
    }

    @GetMapping("/api/livro-com-autor/{id}")
    public ResponseEntity<?> buscarLivroEAutor(@PathVariable Long id) {

        LivroResponse livro = livroClient.detalha(id);

        if (livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado na API de Livraria");
        }

        AutorResponse autor = autorClient.detalha(livro.getAutorId());

        if (autor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro com Autor inválido");
        }

        return ResponseEntity.ok(new LivroExposicaoResponse(livro, autor));
    }
}
