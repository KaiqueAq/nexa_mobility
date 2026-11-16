package br.com.nexa_mobility.model.repository;

import br.com.nexa_mobility.model.entity.CarrosEntity;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrosRepository  extends JpaRepository<CarrosEntity, Long> {


    Optional<CarrosEntity> findByPlaca(String placa);
}
