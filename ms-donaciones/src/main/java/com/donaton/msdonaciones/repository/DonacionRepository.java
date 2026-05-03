package com.donaton.msdonaciones.repository;

import com.donaton.msdonaciones.model.Donacion;
import com.donaton.msdonaciones.model.EstadoDonacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {

    List<Donacion> findByDonanteId(Long donanteId);

    List<Donacion> findByBeneficiarioId(Long beneficiarioId);

    List<Donacion> findByCentroAcopioId(Long centroAcopioId);

    List<Donacion> findByEstado(EstadoDonacion estado);

    List<Donacion> findByCentroAcopioIdAndEstado(Long centroAcopioId, EstadoDonacion estado);
}