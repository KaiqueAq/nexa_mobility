package br.com.nexa_mobility.model.repository;

import br.com.nexa_mobility.model.entity.MotoEntity; // Importação corrigida
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoRepository extends JpaRepository<MotoEntity, Long> {

    Optional<MotoEntity> findByPlaca(String placa);
}
