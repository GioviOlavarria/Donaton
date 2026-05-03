package com.donaton.msdonaciones.controller;

import com.donaton.msdonaciones.service.DonacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donaciones")
@RequiredArgsConstructor
public class DonacionViewController {

    private final DonacionService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("donaciones", service.listarTodas());
        return "donaciones/index";
    }
}