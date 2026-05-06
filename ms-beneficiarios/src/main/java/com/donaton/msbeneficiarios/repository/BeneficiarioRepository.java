package com.donaton.msbeneficiarios.repository;

import com.donaton.msbeneficiarios.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    List<Beneficiario> findByActivoTrue();

    List<Beneficiario> findByCentroAcopioId(Long centroAcopioId);

    List<Beneficiario> findByCentroAcopioIdAndActivoTrue(Long centroAcopioId);

    Optional<Beneficiario> findByRut(String rut);

    boolean existsByRut(String rut);

    void deleteByCentroAcopioId(Long centroAcopioId);
}
