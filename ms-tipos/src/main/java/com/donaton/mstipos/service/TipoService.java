package com.donaton.mstipos.service;

import com.donaton.mstipos.model.TipoBeneficiante;
import com.donaton.mstipos.model.TipoDonacion;
import com.donaton.mstipos.repository.TipoBeneficianteRepository;
import com.donaton.mstipos.repository.TipoDonacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoDonacionRepository donacionRepo;
    private final TipoBeneficianteRepository beneficianteRepo;

    // ---- Tipo Donacion ----
    public List<TipoDonacion> listarTiposDonacion() {
        return donacionRepo.findAllByOrderByClasificacionAsc();
    }

    public TipoDonacion buscarTipoDonacion(Long id) {
        return donacionRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de donación no encontrado con id: " + id));
    }

    @Transactional
    public TipoDonacion guardarTipoDonacion(TipoDonacion tipo) {
        return donacionRepo.save(tipo);
    }

    @Transactional
    public TipoDonacion actualizarTipoDonacion(Long id, TipoDonacion datos) {
        TipoDonacion existente = buscarTipoDonacion(id);
        existente.setClasificacion(datos.getClasificacion());
        existente.setDescripcion(datos.getDescripcion());
        return donacionRepo.save(existente);
    }

    @Transactional
    public void eliminarTipoDonacion(Long id) {
        donacionRepo.delete(buscarTipoDonacion(id));
    }

    // ---- Tipo Beneficiante ----
    public List<TipoBeneficiante> listarTiposBeneficiante() {
        return beneficianteRepo.findAllByOrderByCategoriaAsc();
    }

    public TipoBeneficiante buscarTipoBeneficiante(Long id) {
        return beneficianteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de beneficiante no encontrado con id: " + id));
    }

    @Transactional
    public TipoBeneficiante guardarTipoBeneficiante(TipoBeneficiante tipo) {
        return beneficianteRepo.save(tipo);
    }

    @Transactional
    public TipoBeneficiante actualizarTipoBeneficiante(Long id, TipoBeneficiante datos) {
        TipoBeneficiante existente = buscarTipoBeneficiante(id);
        existente.setCategoria(datos.getCategoria());
        return beneficianteRepo.save(existente);
    }

    @Transactional
    public void eliminarTipoBeneficiante(Long id) {
        beneficianteRepo.delete(buscarTipoBeneficiante(id));
    }
}
