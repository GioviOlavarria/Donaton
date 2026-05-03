package com.donaton.mscentrosacopio.repository;

import com.donaton.mscentrosacopio.model.CentroAcopio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroAcopioRepository extends JpaRepository<CentroAcopio, Long> {

    List<CentroAcopio> findByActivoTrue();

    List<CentroAcopio> findByComunaIgnoreCase(String comuna);
}
