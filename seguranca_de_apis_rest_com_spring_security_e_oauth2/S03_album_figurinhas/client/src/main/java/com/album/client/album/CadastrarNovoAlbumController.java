package com.album.client.album;

import com.album.client.album.integrations.AlbumClient;
import com.album.client.album.integrations.response.DetalhaAlbumResponse;
import com.album.client.album.request.CadastrarNovoAlbumRequest;
import com.album.client.album.response.AlbumFreemiumResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class CadastrarNovoAlbumController {

    private final AlbumClient albumClient;

    public CadastrarNovoAlbumController(AlbumClient albumClient) {
        this.albumClient = albumClient;
    }

    @PostMapping("/api/albuns")
    public ResponseEntity<?> cadastra(@Valid @RequestBody CadastrarNovoAlbumRequest request){

        ResponseEntity<Void> cadastraResponse = albumClient.cadastra(request);

        if(cadastraResponse.getStatusCodeValue() != 201){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao cadastrar novo album");
        }

        String location = cadastraResponse.getHeaders().getLocation().toString();
        Long albumId = Long.valueOf(location.substring(location.lastIndexOf("/") + 1));

        DetalhaAlbumResponse detalhaAlbumResponse = albumClient.detalha(albumId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado"));

        return ResponseEntity.ok(new AlbumFreemiumResponse(detalhaAlbumResponse));
    }
}
