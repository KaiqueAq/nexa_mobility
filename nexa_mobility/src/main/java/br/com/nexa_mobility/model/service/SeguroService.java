package br.com.nexa_mobility.model.service;

import br.com.nexa_mobility.model.entity.SeguroEntity;
import br.com.nexa_mobility.model.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeguroService {
    @Autowired
    private SeguroRepository repository;

    public List<SeguroEntity> listarTodosSeguros() {
        return repository.findAll();
    }

    public SeguroEntity salvarSeguros(SeguroEntity seguro) {
        if (repository.findByNumeroApolice(seguro.getNumeroApolice()).isPresent()) {
            throw new IllegalArgumentException("Seguro já existe");
        }
        return repository.save(seguro);
    }

    public SeguroEntity atualizarSeguros (Long id, SeguroEntity seguro){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Seguro não encontrado");
        }
        seguro.setId(id);
        return repository.save(seguro);
    }

    public void deletarSeguros(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Seguro não encontrado");
        }
        repository.deleteById(id);
    }
}
