package com.donaton.msbeneficiarios.service;

import com.donaton.msbeneficiarios.model.Beneficiario;
import com.donaton.msbeneficiarios.repository.BeneficiarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {

    private final BeneficiarioRepository repository;

    public List<Beneficiario> listarTodos() {
        return repository.findAll();
    }

    public List<Beneficiario> listarActivos() {
        return repository.findByActivoTrue();
    }

    public List<Beneficiario> listarPorCentro(Long centroAcopioId) {
        return repository.findByCentroAcopioId(centroAcopioId);
    }

    public List<Beneficiario> listarActivosPorCentro(Long centroAcopioId) {
        return repository.findByCentroAcopioIdAndActivoTrue(centroAcopioId);
    }

    public Beneficiario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Beneficiario no encontrado con id: " + id));
    }

    @Transactional
    public Beneficiario guardar(Beneficiario beneficiario) {
        if (repository.existsByRut(beneficiario.getRut())) {
            throw new IllegalArgumentException(
                    "Ya existe un beneficiario registrado con el RUT: " + beneficiario.getRut());
        }
        return repository.save(beneficiario);
    }

    @Transactional
    public Beneficiario actualizar(Long id, Beneficiario datos) {
        Beneficiario existente = buscarPorId(id);

        if (!existente.getRut().equalsIgnoreCase(datos.getRut())
                && repository.existsByRut(datos.getRut())) {
            throw new IllegalArgumentException(
                    "El RUT " + datos.getRut() + " ya está en uso");
        }

        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setRut(datos.getRut());
        existente.setTelefono(datos.getTelefono());
        existente.setNecesidad(datos.getNecesidad());
        existente.setCentroAcopioId(datos.getCentroAcopioId());
        existente.setActivo(datos.getActivo());

        return repository.save(existente);
    }

    @Transactional
    public void desactivar(Long id) {
        Beneficiario existente = buscarPorId(id);
        existente.setActivo(false);
        repository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        Beneficiario existente = buscarPorId(id);
        repository.delete(existente);
    }
}
