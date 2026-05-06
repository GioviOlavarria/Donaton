package com.donaton.mscentrosacopio.service;


import com.donaton.mscentrosacopio.client.RelacionMicroserviciosClient;
import com.donaton.mscentrosacopio.model.CentroAcopio;
import com.donaton.mscentrosacopio.repository.CentroAcopioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CentroAcopioService {
    private final CentroAcopioRepository repository;
    private final RelacionMicroserviciosClient relacionMicroserviciosClient;

    public List<CentroAcopio> listarTodos() {
        return repository.findAll();
    }

    public List<CentroAcopio> listarActivos() {
        return repository.findByActivoTrue();
    }

    public CentroAcopio buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Centro de Acopio no encontrado con id: "+id));
    }

    @Transactional
    public CentroAcopio guardar(CentroAcopio centro) {
        return repository.save(centro);
    }

    public CentroAcopio actualizar(Long id, CentroAcopio datos) {
        CentroAcopio existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setDireccion(datos.getDireccion());
        existente.setTelefono(datos.getTelefono());
        existente.setComuna(datos.getComuna());
        existente.setEmail(datos.getEmail());
        existente.setActivo(datos.getActivo());

        return repository.save(existente);
    }

    public void eliminar(Long id){
        CentroAcopio existente = buscarPorId(id);
        relacionMicroserviciosClient.eliminarDatosAsociadosAlCentro(id);
        repository.delete(existente);
    }

    public void desactivar(Long id){
        CentroAcopio existente = buscarPorId(id);
        existente.setActivo(false);
        repository.save(existente);
    }

}
