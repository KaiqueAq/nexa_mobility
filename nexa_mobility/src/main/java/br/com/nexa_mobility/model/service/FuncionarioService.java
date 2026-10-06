package br.com.nexa_mobility.model.service;

import br.com.nexa_mobility.model.entity.FuncionarioEntity;
import br.com.nexa_mobility.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    //Get
    public List<FuncionarioEntity> listarTodosFuncionarios() {
        return repository.findAll();
    }

    //Post

    public FuncionarioEntity salvarFuncionario(FuncionarioEntity funcionario) {
        if (repository.findByMatricula(funcionario.getMatricula()).isPresent())
            throw new IllegalArgumentException("Funcionário já cadastrado");

        return repository.save(funcionario);

    }
        // Put

    public FuncionarioEntity atualizarFuncionario ( Long id,FuncionarioEntity funcionario ){
            if(!repository.existsById(id))
                throw new IllegalArgumentException("Funcionário não encontrado");

            funcionario.setId(id);
            return repository.save(funcionario);

    }

        public void deletarFuncionario (Long id) {
            if (!repository.existsById(id)) {
                throw new IllegalArgumentException("Funcionario não encontrado");

            }

            repository.deleteById(id);

    }
}


