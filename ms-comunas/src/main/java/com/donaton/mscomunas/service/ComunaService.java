package com.donaton.mscomunas.service;

import com.donaton.mscomunas.model.Comuna;
import com.donaton.mscomunas.repository.ComunaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComunaService {

    private final ComunaRepository repository;

    public List<Comuna> listarTodas() {
        return repository.findAllByOrderByNombreAsc();
    }

    public List<Comuna> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCaseOrderByNombreAsc(nombre);
    }

    public Comuna buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comuna no encontrada con id: " + id));
    }

    @Transactional
    public Comuna guardar(Comuna comuna) {
        return repository.save(comuna);
    }

    @Transactional
    public Comuna actualizar(Long id, Comuna datos) {
        Comuna existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        return repository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        Comuna existente = buscarPorId(id);
        repository.delete(existente);
    }
}
