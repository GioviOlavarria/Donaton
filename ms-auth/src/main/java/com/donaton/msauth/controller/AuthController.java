package com.donaton.msauth.controller;

import com.donaton.msauth.dto.AuthResponse;
import com.donaton.msauth.dto.LoginRequest;
import com.donaton.msauth.dto.RegistroRequest;
import com.donaton.msauth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registrar(@Valid @RequestBody RegistroRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(req));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(service.login(req));
    }

    @PostMapping("/validar")
    public ResponseEntity<Map<String, Boolean>> validar(@RequestBody Map<String, String> body) {
        String token = body.getOrDefault("token", "");
        return ResponseEntity.ok(Map.of("valido", service.validar(token)));
    }
}
