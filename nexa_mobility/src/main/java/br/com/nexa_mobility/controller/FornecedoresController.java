package br.com.nexa_mobility.controller;

import br.com.nexa_mobility.model.entity.FornecedoresEntity;
import br.com.nexa_mobility.model.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {
    @Autowired
    private FornecedoresService service;

    //    get
    @GetMapping
    public List<FornecedoresEntity> listar() {
        return service.listTodosFornecedores();
    }

    //    post
    @PostMapping
    public ResponseEntity<Map<String, Object>> salva(@RequestBody FornecedoresEntity fornecedores) {
        service.salvarFornecedores(fornecedores);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Fornecedores Criado"));
    }

    //    put
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody FornecedoresEntity fornecedores) {
        service.atualizarFornecedores(id, fornecedores);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedores atualizado"));
    }

    //    delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
        service.deletarFornecedores(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedores deletado"));
    }

}
