package br.com.nexa_mobility.model.service;

import br.com.nexa_mobility.model.entity.ClienteEntity;
import br.com.nexa_mobility.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // get - Corrigido o tipo de retorno para List<ClienteEntity>
    public List<ClienteEntity> listarTodosClientes() {
        return repository.findAll();
    }

    // post
    public ClienteEntity salvarClientes(ClienteEntity cliente) {
        if (repository.findByNome(cliente.getNome()).isPresent()) {
            throw new IllegalArgumentException("Cliente já existe");
        }
        return repository.save(cliente);
    }
    // put
    public ClienteEntity atualizarCliente ( Long id,ClienteEntity cliente){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado");
        return repository.save(cliente);

    }
    // delete
    public void deletarCliente(Long id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado");

        repository.deleteById(id);
    }

}

