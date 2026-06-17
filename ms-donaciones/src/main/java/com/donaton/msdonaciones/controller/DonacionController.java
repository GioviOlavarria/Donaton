package com.donaton.msdonaciones.controller;

import com.donaton.msdonaciones.model.Donacion;
import com.donaton.msdonaciones.model.EstadoDonacion;
import com.donaton.msdonaciones.service.DonacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/donaciones")
@RequiredArgsConstructor
public class DonacionController {

    private final DonacionService service;

    @GetMapping
    public ResponseEntity<List<Donacion>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donacion> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/donante/{donanteId}")
    public ResponseEntity<List<Donacion>> listarPorDonante(@PathVariable Long donanteId) {
        return ResponseEntity.ok(service.listarPorDonante(donanteId));
    }

    @GetMapping("/beneficiario/{beneficiarioId}")
    public ResponseEntity<List<Donacion>> listarPorBeneficiario(@PathVariable Long beneficiarioId) {
        return ResponseEntity.ok(service.listarPorBeneficiario(beneficiarioId));
    }

    @GetMapping("/centro/{centroId}")
    public ResponseEntity<List<Donacion>> listarPorCentro(@PathVariable Long centroId) {
        return ResponseEntity.ok(service.listarPorCentro(centroId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Donacion>> listarPorEstado(@PathVariable EstadoDonacion estado) {
        return ResponseEntity.ok(service.listarPorEstado(estado));
    }

    @GetMapping("/centro/{centroId}/estado/{estado}")
    public ResponseEntity<List<Donacion>> listarPorCentroYEstado(
            @PathVariable Long centroId,
            @PathVariable EstadoDonacion estado) {
        return ResponseEntity.ok(service.listarPorCentroYEstado(centroId, estado));
    }

    @PostMapping
    public ResponseEntity<Donacion> crear(@Valid @RequestBody Donacion donacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(donacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donacion> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Donacion donacion) {
        return ResponseEntity.ok(service.actualizar(id, donacion));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Donacion> cambiarEstado(
            @PathVariable Long id,
            @RequestParam EstadoDonacion nuevoEstado) {
        return ResponseEntity.ok(service.cambiarEstado(id, nuevoEstado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/centro/{centroId}")
    public ResponseEntity<Void> eliminarPorCentro(@PathVariable Long centroId) {
        service.eliminarPorCentro(centroId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> contarDonaciones() {
        return ResponseEntity.ok(Collections.singletonMap("count", service.countDonacion()));
    }
}