package br.com.nexa_mobility.controller;

import br.com.nexa_mobility.model.entity.CarrosEntity;
import br.com.nexa_mobility.model.entity.ClienteEntity;
import br.com.nexa_mobility.model.service.CarrosService;
import br.com.nexa_mobility.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    @Autowired
    private CarrosService service;

    //    get
    @GetMapping
    public List<CarrosEntity> listarTodos() {

        return service.listarTodosCarros();
    }

    //post
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody CarrosEntity carros) {
        service.salvarCarros(carros);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Carro criado com sucesso"));

    }
    //put
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar (@PathVariable Long id,@RequestBody CarrosEntity carros){
        service.atualizarCarros(id,carros);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Carro atualizado com sucesso!"));
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarCliente(@PathVariable Long id){
        service.deletarCarros(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Carro deletado com sucesso!"));
    }

}
