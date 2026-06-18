package com.donaton.mscomunas.controller;

import com.donaton.mscomunas.model.Comuna;
import com.donaton.mscomunas.service.ComunaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunas")
@RequiredArgsConstructor
public class ComunaController {

    private final ComunaService service;

    @GetMapping
    public ResponseEntity<List<Comuna>> listar(@RequestParam(required = false) String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            return ResponseEntity.ok(service.buscarPorNombre(nombre));
        }
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Comuna> crear(@Valid @RequestBody Comuna comuna) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(comuna));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizar(@PathVariable Long id, @Valid @RequestBody Comuna comuna) {
        return ResponseEntity.ok(service.actualizar(id, comuna));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
