package br.com.nexa_mobility.controller;

import br.com.nexa_mobility.model.entity.SeguroEntity;
import br.com.nexa_mobility.model.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
    @Autowired
    private SeguroService service;

    @GetMapping
    public List<SeguroEntity> listarTodos() {
        return service.listarTodosSeguros();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody SeguroEntity seguro) {
        service.salvarSeguros(seguro);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Seguro criado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody SeguroEntity seguro){
        service.atualizarSeguros(id, seguro);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Seguro atualizado com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarSeguro(@PathVariable Long id){
        service.deletarSeguros(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Seguro deletado com sucesso!"));
    }
}
