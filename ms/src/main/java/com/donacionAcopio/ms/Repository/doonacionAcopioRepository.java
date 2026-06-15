package com.donacionAcopio.ms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donacionAcopio.ms.Model.DonacionAcopio;

@Repository
public interface doonacionAcopioRepository extends JpaRepository<DonacionAcopio,Long>{
    List<DonacionAcopio> findByDonacionId(Long donacionId);
    List<DonacionAcopio> findByAcopioId(Long acopioId);
}
