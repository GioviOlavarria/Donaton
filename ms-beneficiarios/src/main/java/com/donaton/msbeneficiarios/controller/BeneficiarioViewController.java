package com.donaton.msbeneficiarios.controller;

import com.donaton.msbeneficiarios.model.Beneficiario;
import com.donaton.msbeneficiarios.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioViewController {

    private final BeneficiarioService service;

    @GetMapping
    public String index(Model model) {
        List<Beneficiario> beneficiarios = service.listarTodos();
        long activos   = beneficiarios.stream().filter(b -> Boolean.TRUE.equals(b.getActivo())).count();
        long inactivos = beneficiarios.stream().filter(b -> !Boolean.TRUE.equals(b.getActivo())).count();

        model.addAttribute("beneficiarios", beneficiarios);
        model.addAttribute("activos",       activos);
        model.addAttribute("inactivos",     inactivos);
        return "beneficiarios/index";
    }
}