package br.com.nexa_mobility.controller;

import br.com.nexa_mobility.model.entity.ClienteEntity;
import br.com.nexa_mobility.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    //    get
    @GetMapping
    public List<ClienteEntity> listarTodos() {
        return service.listarTodosClientes();
    }

    //post
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteEntity cliente) {
        service.salvarClientes(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente criado com sucesso"));

    }
    //put
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar (@PathVariable Long id,@RequestBody ClienteEntity cliente){
        service.atualizarCliente(id,cliente);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente atualizado com sucesso!"));
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente deletado com sucesso!"));
    }




}
