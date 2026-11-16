package br.com.nexa_mobility.controller;

import br.com.nexa_mobility.model.entity.MotoEntity;
import br.com.nexa_mobility.model.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/motos") // Alterado de /seguros para /motos
public class MotoController {

    @Autowired
    private MotoService service;

    // GET - Listar todas as motos
    @GetMapping
    public List<MotoEntity> listar() {
        return service.listTodasMotos();
    }

    // POST - Criar uma nova moto
    @PostMapping
    public ResponseEntity<Map<String, Object>> salva(@RequestBody MotoEntity moto) {
        service.salvarMoto(moto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Moto criada com sucesso"));
    }

    // PUT - Atualizar uma moto existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody MotoEntity moto) {
        service.atualizarMoto(id, moto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Moto atualizada com sucesso"));
    }

    // DELETE - Deletar uma moto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
        service.deletarMoto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Moto deletada com sucesso"));
    }
}
