package com.donaton.msdonantes.service;

import com.donaton.msdonantes.model.Donante;
import com.donaton.msdonantes.repository.DonanteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonanteService {

    private final DonanteRepository repository;

    public List<Donante> listarTodos() {
        return repository.findAll();
    }

    public List<Donante> listarActivos() {
        return repository.findByActivoTrue();
    }

    public Donante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Donante no encontrado con id: " + id));
    }

    @Transactional
    public Donante guardar(Donante donante) {
        if (repository.existsByEmail(donante.getEmail())) {
            throw new IllegalArgumentException(
                    "Ya existe un donante registrado con el email: " + donante.getEmail());
        }
        return repository.save(donante);
    }

    @Transactional
    public Donante actualizar(Long id, Donante datos) {
        Donante existente = buscarPorId(id);


        if (!existente.getEmail().equalsIgnoreCase(datos.getEmail())
                && repository.existsByEmail(datos.getEmail())) {
            throw new IllegalArgumentException(
                    "El email " + datos.getEmail() + " ya está en uso");
        }

        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setEmail(datos.getEmail());
        existente.setTelefono(datos.getTelefono());
        existente.setDireccion(datos.getDireccion());
        existente.setActivo(datos.getActivo());

        return repository.save(existente);
    }

    @Transactional
    public void desactivar(Long id) {
        Donante existente = buscarPorId(id);
        existente.setActivo(false);
        repository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        Donante existente = buscarPorId(id);
        repository.delete(existente);
    }
}
