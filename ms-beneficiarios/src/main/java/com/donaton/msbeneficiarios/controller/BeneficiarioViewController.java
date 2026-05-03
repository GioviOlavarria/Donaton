package com.donaton.msbeneficiarios.controller;

import com.donaton.msbeneficiarios.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioViewController {

    private final BeneficiarioService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("beneficiarios", service.listarTodos());
        return "beneficiarios/index";
    }
}