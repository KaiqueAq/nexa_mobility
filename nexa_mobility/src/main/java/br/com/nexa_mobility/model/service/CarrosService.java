package br.com.nexa_mobility.model.service;


import br.com.nexa_mobility.model.entity.CarrosEntity;
import br.com.nexa_mobility.model.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarrosService {
    @Autowired
    private CarrosRepository repository;

    // get
    public List<CarrosEntity> listarTodosCarros() {
        return repository.findAll();
    }

    // post
    public CarrosEntity salvarCarros(CarrosEntity carros) {
        if (repository.findByPlaca(carros.getPlaca()).isPresent()) {
            throw new IllegalArgumentException("Carros já existe");
        }
        return repository.save(carros);
    }
    // put
    public CarrosEntity atualizarCarros (Long id, CarrosEntity carros){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Carros não encontrado");
        return repository.save(carros);

    }
    // delete
    public void deletarCarros(Long id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Carros não encontrado");

        repository.deleteById(id);
    }

}
