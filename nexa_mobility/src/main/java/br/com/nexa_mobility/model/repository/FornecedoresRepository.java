package br.com.nexa_mobility.model.repository;

import br.com.nexa_mobility.model.entity.FornecedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity, Long> {
    Optional<FornecedoresEntity> findByEmail(String email);
}
