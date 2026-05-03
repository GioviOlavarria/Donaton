package com.donaton.mscentrosacopio.controller;

import com.donaton.mscentrosacopio.service.CentroAcopioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/centros")
@RequiredArgsConstructor
public class CentroAcopioViewController {

    private final CentroAcopioService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("centros", service.listarTodos());
        return "centros/index";
    }
}