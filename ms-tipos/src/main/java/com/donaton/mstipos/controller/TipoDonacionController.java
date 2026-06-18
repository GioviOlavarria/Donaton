package com.donaton.mstipos.controller;

import com.donaton.mstipos.model.TipoDonacion;
import com.donaton.mstipos.service.TipoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-donacion")
@RequiredArgsConstructor
public class TipoDonacionController {

    private final TipoService service;

    @GetMapping
    public ResponseEntity<List<TipoDonacion>> listar() {
        return ResponseEntity.ok(service.listarTiposDonacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDonacion> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarTipoDonacion(id));
    }

    @PostMapping
    public ResponseEntity<TipoDonacion> crear(@Valid @RequestBody TipoDonacion tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardarTipoDonacion(tipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDonacion> actualizar(@PathVariable Long id, @Valid @RequestBody TipoDonacion tipo) {
        return ResponseEntity.ok(service.actualizarTipoDonacion(id, tipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarTipoDonacion(id);
        return ResponseEntity.noContent().build();
    }
}
