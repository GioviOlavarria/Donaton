package com.donaton.msdonantes.controller;

import com.donaton.msdonantes.model.Donante;
import com.donaton.msdonantes.service.DonanteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donantes")
@RequiredArgsConstructor
public class DonanteController {

    private final DonanteService service;


    @GetMapping
    public ResponseEntity<List<Donante>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }


    @GetMapping("/activos")
    public ResponseEntity<List<Donante>> listarActivos() {
        return ResponseEntity.ok(service.listarActivos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Donante> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/centro/{centroId}")
    public ResponseEntity<List<Donante>> listarPorCentro(@PathVariable Long centroId) {
        return ResponseEntity.ok(service.listarPorCentro(centroId));
    }


    @PostMapping
    public ResponseEntity<Donante> crear(@Valid @RequestBody Donante donante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(donante));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Donante> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Donante donante) {
        return ResponseEntity.ok(service.actualizar(id, donante));
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
}
