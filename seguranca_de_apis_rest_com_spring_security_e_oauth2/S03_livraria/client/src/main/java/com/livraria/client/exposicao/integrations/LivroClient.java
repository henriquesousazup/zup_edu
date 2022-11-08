package com.livraria.client.exposicao.integrations;

import com.livraria.client.exposicao.integrations.response.LivroResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "livroClient",
        url = "${integrations.livro-url}"
)
public interface LivroClient {

    @GetMapping("/{id}")
    public LivroResponse detalha(@PathVariable("id") Long id);

}
