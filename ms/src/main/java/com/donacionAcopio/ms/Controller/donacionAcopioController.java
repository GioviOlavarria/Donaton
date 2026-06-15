package com.donacionAcopio.ms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.donacionAcopio.ms.Model.DonacionAcopio;
import com.donacionAcopio.ms.Service.donacionAcopioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class donacionAcopioController {
    @Autowired
    private donacionAcopioService serviceDonacionAcopio;

    @GetMapping("/donacionAcopio")
    public ResponseEntity<List<DonacionAcopio>> getDonacionAcopio(){
        List<DonacionAcopio> donacionAcopios = serviceDonacionAcopio.getDonacionAcopios();
        if(donacionAcopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donacionAcopios);
    }
    
    @GetMapping("/donancionAcopio/{id}")
    public ResponseEntity<DonacionAcopio> getDonacionAcopioById(@PathVariable Long id){
        DonacionAcopio donacionAcopio = serviceDonacionAcopio.getDonacionAcopiosById(id);
        if(donacionAcopio == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donacionAcopio);
    }
    

    @GetMapping("/donacionAcopio/{acopioId}")
    public ResponseEntity<List<DonacionAcopio>> getDonacionAcopioByAcopioId(@PathVariable Long acopioId){
        List<DonacionAcopio> donacionAcopios = serviceDonacionAcopio.getDonacionAcopiosByAcopioId(acopioId);
        if(donacionAcopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donacionAcopios);
    }

    @GetMapping("/donacionAcopio/donacion/{donacionId}")
    public ResponseEntity<List<DonacionAcopio>> getDonacionAcopioByDonacionId(@PathVariable Long donacionId){
        List<DonacionAcopio> donacionAcopios = serviceDonacionAcopio.getDonacionAcopiosByDonacionId(donacionId);
        if(donacionAcopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(donacionAcopios);
    }

    @PostMapping("/donacionAcopio")
    public ResponseEntity<DonacionAcopio> postDonacionAcopio(@RequestBody DonacionAcopio donacionAcopio){
        DonacionAcopio newDonacionAcopio = serviceDonacionAcopio.saveDonacionAcopio(donacionAcopio);
        return ResponseEntity.ok(newDonacionAcopio);
    }

    @PutMapping("/donacionAcopio/{id}")
    public ResponseEntity<DonacionAcopio> putDonacionAcopio(@PathVariable Long id, @RequestBody DonacionAcopio donacionAcopio) {
        try{

            DonacionAcopio donaAco = serviceDonacionAcopio.getDonacionAcopiosById(id);

            donaAco.setDonacionId(donacionAcopio.getDonacionId());
            donaAco.setAcopioId(donacionAcopio.getAcopioId());
            donaAco.setFechaCreacion(donacionAcopio.getFechaCreacion());
            donaAco.setEstado(donacionAcopio.getEstado());

            DonacionAcopio updatedDonacionAcopio = serviceDonacionAcopio.saveDonacionAcopio(donaAco);
            return ResponseEntity.ok(updatedDonacionAcopio);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/donacionAcopio/{id}")
    public ResponseEntity<Void> deleteDonacionAcopio(@PathVariable Long id){
        try{
            serviceDonacionAcopio.deleteDonacionAcopio(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}