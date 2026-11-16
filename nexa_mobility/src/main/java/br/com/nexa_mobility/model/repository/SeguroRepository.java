package br.com.nexa_mobility.model.repository;

import br.com.nexa_mobility.model.entity.SeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {
    Optional<SeguroEntity> findByNumeroApolice(int numeroApolice);
}
