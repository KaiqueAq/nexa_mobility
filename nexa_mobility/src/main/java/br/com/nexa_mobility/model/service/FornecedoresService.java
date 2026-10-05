package br.com.nexa_mobility.model.service;

import br.com.nexa_mobility.model.entity.FornecedoresEntity;
import br.com.nexa_mobility.model.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {
    @Autowired
    private FornecedoresRepository repository;

    //    get
    public List<FornecedoresEntity> listTodosFornecedores() {
        return repository.findAll();
    }

    //    post
    public FornecedoresEntity salvarFornecedores(FornecedoresEntity fornecedores) {
        if (repository.findByEmail(fornecedores.getEmail()).isPresent())
            throw new IllegalArgumentException("Fornecedores já existe!");

        return repository.save(fornecedores);
    }

    //    put
    public FornecedoresEntity atualizarFornecedores(Long id, FornecedoresEntity fornecedores) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Fornecedor não encontrado!");

        fornecedores.setId(id);
        return repository.save(fornecedores);
    }

    //    delete
    public void deletarFornecedores(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Fornecedor não encotrado!");

        repository.deleteById(id);
    }
}
