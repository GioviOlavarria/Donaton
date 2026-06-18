package com.donaton.mstipos.repository;

import com.donaton.mstipos.model.TipoBeneficiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoBeneficianteRepository extends JpaRepository<TipoBeneficiante, Long> {
    List<TipoBeneficiante> findAllByOrderByCategoriaAsc();
}
