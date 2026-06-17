package com.donaton.msdonaciones.service;

import com.donaton.msdonaciones.model.Donacion;
import com.donaton.msdonaciones.model.EstadoDonacion;
import com.donaton.msdonaciones.repository.DonacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonacionService {

    private final DonacionRepository repository;

    public List<Donacion> listarTodas() {
        return repository.findAll();
    }

    public List<Donacion> listarPorDonante(Long donanteId) {
        return repository.findByDonanteId(donanteId);
    }

    public List<Donacion> listarPorBeneficiario(Long beneficiarioId) {
        return repository.findByBeneficiarioId(beneficiarioId);
    }

    public List<Donacion> listarPorCentro(Long centroAcopioId) {
        return repository.findByCentroAcopioId(centroAcopioId);
    }

    public List<Donacion> listarPorEstado(EstadoDonacion estado) {
        return repository.findByEstado(estado);
    }

    public List<Donacion> listarPorCentroYEstado(Long centroAcopioId, EstadoDonacion estado) {
        return repository.findByCentroAcopioIdAndEstado(centroAcopioId, estado);
    }

    public Donacion buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Donación no encontrada con id: " + id));
    }

    @Transactional
    public Donacion guardar(Donacion donacion) {
        return repository.save(donacion);
    }

    @Transactional
    public Donacion actualizar(Long id, Donacion datos) {
        Donacion existente = buscarPorId(id);

        existente.setDonanteId(datos.getDonanteId());
        existente.setBeneficiarioId(datos.getBeneficiarioId());
        existente.setCentroAcopioId(datos.getCentroAcopioId());
        existente.setArticulo(datos.getArticulo());
        existente.setCantidad(datos.getCantidad());
        existente.setObservaciones(datos.getObservaciones());

        return repository.save(existente);
    }

    @Transactional
    public Donacion cambiarEstado(Long id, EstadoDonacion nuevoEstado) {
        Donacion existente = buscarPorId(id);
        existente.setEstado(nuevoEstado);
        return repository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        Donacion existente = buscarPorId(id);
        repository.delete(existente);
    }

    @Transactional
    public void eliminarPorCentro(Long centroAcopioId) {
        repository.deleteByCentroAcopioId(centroAcopioId);
    }

    public long countDonacion(){
        return repository.count();
    }
}