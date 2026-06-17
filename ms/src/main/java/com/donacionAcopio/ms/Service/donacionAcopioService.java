package com.donacionAcopio.ms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donacionAcopio.ms.Model.DonacionAcopio;
import com.donacionAcopio.ms.Repository.doonacionAcopioRepository;

@Service
public class donacionAcopioService {
    @Autowired
    private doonacionAcopioRepository repositoryDonacionAcopio;

    public List<DonacionAcopio> getDonacionAcopios(){
        return repositoryDonacionAcopio.findAll();
    }

    public DonacionAcopio getDonacionAcopiosById(Long id){
        return repositoryDonacionAcopio.findById(id).orElse(null);
    }

    public List<DonacionAcopio> getDonacionAcopiosByDonacionId(Long donacionId){
        return repositoryDonacionAcopio.findByDonacionId(donacionId);
    }

    public List<DonacionAcopio> getDonacionAcopiosByAcopioId(Long acopioId){
        return repositoryDonacionAcopio.findByAcopioId(acopioId);
    }

    public DonacionAcopio saveDonacionAcopio(DonacionAcopio donacionAcopio){
        return repositoryDonacionAcopio.save(donacionAcopio);
    }

    public void deleteDonacionAcopio(Long id){
        repositoryDonacionAcopio.deleteById(id);
    }

    public long countDonacionAcopio(){
        return repositoryDonacionAcopio.count();
    }
}
