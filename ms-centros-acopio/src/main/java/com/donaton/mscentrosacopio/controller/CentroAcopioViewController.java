package com.donaton.mscentrosacopio.controller;

import com.donaton.mscentrosacopio.model.CentroAcopio;
import com.donaton.mscentrosacopio.service.CentroAcopioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/centros")
@RequiredArgsConstructor
public class CentroAcopioViewController {

    private final CentroAcopioService service;

    @GetMapping
    public String index(Model model) {
        List<CentroAcopio> centros = service.listarTodos();
        long activos   = centros.stream().filter(c -> Boolean.TRUE.equals(c.getActivo())).count();
        long inactivos = centros.stream().filter(c -> !Boolean.TRUE.equals(c.getActivo())).count();

        model.addAttribute("centros",   centros);
        model.addAttribute("activos",   activos);
        model.addAttribute("inactivos", inactivos);
        return "centros/index";
    }
}