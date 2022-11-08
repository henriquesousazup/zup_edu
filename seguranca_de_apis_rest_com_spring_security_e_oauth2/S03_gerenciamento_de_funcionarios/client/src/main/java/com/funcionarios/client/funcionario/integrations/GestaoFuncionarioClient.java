package com.funcionarios.client.funcionario.integrations;

import com.funcionarios.client.funcionario.FuncionarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "gestaoFuncionarioClient",
        url = "localhost:8080/oauth2-resourceserver-gestao-funcionarios"
)
public interface GestaoFuncionarioClient {

    @GetMapping("/api/funcionarios")
    public List<FuncionarioResponse> lista();

}
