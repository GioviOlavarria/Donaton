package com.donaton.mstipos.controller;

import com.donaton.mstipos.model.TipoBeneficiante;
import com.donaton.mstipos.service.TipoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-beneficiante")
@RequiredArgsConstructor
public class TipoBeneficianteController {

    private final TipoService service;

    @GetMapping
    public ResponseEntity<List<TipoBeneficiante>> listar() {
        return ResponseEntity.ok(service.listarTiposBeneficiante());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoBeneficiante> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarTipoBeneficiante(id));
    }

    @PostMapping
    public ResponseEntity<TipoBeneficiante> crear(@Valid @RequestBody TipoBeneficiante tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardarTipoBeneficiante(tipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoBeneficiante> actualizar(@PathVariable Long id, @Valid @RequestBody TipoBeneficiante tipo) {
        return ResponseEntity.ok(service.actualizarTipoBeneficiante(id, tipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarTipoBeneficiante(id);
        return ResponseEntity.noContent().build();
    }
}
