package com.album.client.album.integrations;

import com.album.client.album.request.CadastrarNovoAlbumRequest;
import com.album.client.album.integrations.response.DetalhaAlbumResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient(
        name = "livroClient",
        url = "${integrations.resource-server-url}"
)
public interface AlbumClient {

    @PostMapping("/api/albuns")
    public ResponseEntity<Void> cadastra(@Valid @RequestBody CadastrarNovoAlbumRequest request);

    @GetMapping("/api/albuns/{id}")
    public Optional<DetalhaAlbumResponse> detalha(@PathVariable Long id);

}
