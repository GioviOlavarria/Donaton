package com.donaton.mscentrosacopio.controller;

import com.donaton.mscentrosacopio.model.CentroAcopio;
import com.donaton.mscentrosacopio.service.CentroAcopioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/centros")
@RequiredArgsConstructor

public class CentroAcopioController {
    private final CentroAcopioService service;

    @GetMapping
    public ResponseEntity<List<CentroAcopio>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<CentroAcopio>> listarActivos() {
        return ResponseEntity.ok(service.listarActivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroAcopio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<CentroAcopio> crear(@Valid @RequestBody CentroAcopio centro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(centro));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CentroAcopio> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CentroAcopio centro) {
        return ResponseEntity.ok(service.actualizar(id, centro));
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

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> contarCentros() {
        return ResponseEntity.ok(Collections.singletonMap("count", service.countCentroAcopio()));
    }

}
