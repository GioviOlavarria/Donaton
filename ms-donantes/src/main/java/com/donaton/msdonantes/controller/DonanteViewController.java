package com.donaton.msdonantes.controller;

import com.donaton.msdonantes.service.DonanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donantes")
@RequiredArgsConstructor
public class DonanteViewController {

    private final DonanteService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("donantes", service.listarTodos());
        return "donantes/index";
    }
}