package com.donaton.msdonantes.controller;

import com.donaton.msdonantes.model.Donante;
import com.donaton.msdonantes.service.DonanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/donantes")
@RequiredArgsConstructor
public class DonanteViewController {

    private final DonanteService service;

    @GetMapping
    public String index(Model model) {
        List<Donante> donantes = service.listarTodos();
        long activos   = donantes.stream().filter(d -> Boolean.TRUE.equals(d.getActivo())).count();
        long inactivos = donantes.stream().filter(d -> !Boolean.TRUE.equals(d.getActivo())).count();

        model.addAttribute("donantes",  donantes);
        model.addAttribute("activos",   activos);
        model.addAttribute("inactivos", inactivos);
        return "donantes/index";
    }
}