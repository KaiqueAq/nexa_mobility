package br.com.nexa_mobility.model.service;

import br.com.nexa_mobility.model.entity.MotoEntity;
import br.com.nexa_mobility.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository repository;

    // GET - Listar todas as motos
    public List<MotoEntity> listTodasMotos() {
        return repository.findAll();
    }

    // POST - Salvar uma nova moto
    public MotoEntity salvarMoto(MotoEntity moto) {
        if (repository.findByPlaca(moto.getPlaca()).isPresent()) {
            throw new IllegalArgumentException("Moto com esta placa já existe!");
        }

        return repository.save(moto);
    }

    // PUT - Atualizar uma moto existente
    public MotoEntity atualizarMoto(Long id, MotoEntity moto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Moto não encontrada!");
        }

        moto.setId(id);
        return repository.save(moto);
    }

    // DELETE - Deletar uma moto por ID
    public void deletarMoto(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Moto não encontrada!");
        }

        repository.deleteById(id);
    }
}
