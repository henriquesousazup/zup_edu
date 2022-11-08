package com.funcionarios.client.funcionario;

import com.funcionarios.client.funcionario.integrations.GestaoFuncionarioClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListaFuncionarioPorCargoController {

    private final GestaoFuncionarioClient gestaoFuncionarioClient;

    public ListaFuncionarioPorCargoController(GestaoFuncionarioClient gestaoFuncionarioClient) {
        this.gestaoFuncionarioClient = gestaoFuncionarioClient;
    }

    @GetMapping("/api/funcionarios-por-cargo")
    public ResponseEntity<?> listaPorCargo(@RequestParam String cargo) {

        List<FuncionarioResponse> funcionarios = gestaoFuncionarioClient.lista().stream()
                .filter(f -> f.getCargo().equalsIgnoreCase(cargo))
                .collect(Collectors.toList());

        return ResponseEntity.ok(funcionarios);
    }
}
