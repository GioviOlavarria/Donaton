package com.donaton.msbeneficiarios.controller;

import com.donaton.msbeneficiarios.model.Beneficiario;
import com.donaton.msbeneficiarios.service.BeneficiarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService service;


    @GetMapping
    public ResponseEntity<List<Beneficiario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }


    @GetMapping("/activos")
    public ResponseEntity<List<Beneficiario>> listarActivos() {
        return ResponseEntity.ok(service.listarActivos());
    }


    @GetMapping("/centro/{centroId}")
    public ResponseEntity<List<Beneficiario>> listarPorCentro(@PathVariable Long centroId) {
        return ResponseEntity.ok(service.listarPorCentro(centroId));
    }


    @GetMapping("/centro/{centroId}/activos")
    public ResponseEntity<List<Beneficiario>> listarActivosPorCentro(@PathVariable Long centroId) {
        return ResponseEntity.ok(service.listarActivosPorCentro(centroId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<Beneficiario> crear(@Valid @RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(beneficiario));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Beneficiario beneficiario) {
        return ResponseEntity.ok(service.actualizar(id, beneficiario));
    }


    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        service.desactivar(id);
        return ResponseEntity.noContent().build();
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
    public ResponseEntity<Map<String, Long>> contarBeneficiarios() {
        return ResponseEntity.ok(Collections.singletonMap("count", service.countBeneficiario()));
    }
}
