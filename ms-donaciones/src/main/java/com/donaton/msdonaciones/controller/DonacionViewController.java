package com.donaton.msdonaciones.controller;

import com.donaton.msdonaciones.model.Donacion;
import com.donaton.msdonaciones.model.EstadoDonacion;
import com.donaton.msdonaciones.service.DonacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/donaciones")
@RequiredArgsConstructor
public class DonacionViewController {

    private final DonacionService service;

    @GetMapping
    public String index(Model model) {
        List<Donacion> donaciones = service.listarTodas();
        long pendientes = donaciones.stream().filter(d -> d.getEstado() == EstadoDonacion.PENDIENTE).count();
        long entregadas = donaciones.stream().filter(d -> d.getEstado() == EstadoDonacion.ENTREGADA).count();
        long enTransito = donaciones.stream().filter(d -> d.getEstado() == EstadoDonacion.EN_TRANSITO).count();
        long asignadas  = donaciones.stream().filter(d -> d.getEstado() == EstadoDonacion.ASIGNADA).count();

        model.addAttribute("donaciones",  donaciones);
        model.addAttribute("pendientes",  pendientes);
        model.addAttribute("entregadas",  entregadas);
        model.addAttribute("enTransito",  enTransito);
        model.addAttribute("asignadas",   asignadas);
        return "donaciones/index";
    }
}