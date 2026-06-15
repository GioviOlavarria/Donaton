package com.donaton.msadmin.controller;

import com.donaton.msadmin.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiController {

    private final GatewayService gateway;

    @GetMapping("/resumen")
    public ResponseEntity<Map<String, Object>> resumen() {
        return ResponseEntity.ok(gateway.resumen());
    }
}
