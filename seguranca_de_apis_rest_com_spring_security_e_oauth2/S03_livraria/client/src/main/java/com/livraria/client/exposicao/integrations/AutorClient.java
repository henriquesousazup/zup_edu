package com.livraria.client.exposicao.integrations;

import com.livraria.client.exposicao.integrations.response.AutorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "autorClient",
        url = "${integrations.autor-url}"
)
public interface AutorClient {

    @GetMapping("/{id}")
    public AutorResponse detalha(@PathVariable Long id);

}
