package com.donaton.msdonantes.repository;


import com.donaton.msdonantes.model.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonanteRepository extends JpaRepository<Donante, Long> {
    List<Donante> findByActivoTrue();

    Optional<Donante> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Donante> findByCentroAcopioId(Long centroAcopioId);

    void deleteByCentroAcopioId(Long centroAcopioId);
}
