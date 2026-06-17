package com.donaton.msadmin.controller;

import com.donaton.msadmin.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminViewController {

    private final GatewayService gateway;

    @Value("${donaton.public.donantes}")
    private String urlDonantes;
    @Value("${donaton.public.beneficiarios}")
    private String urlBeneficiarios;
    @Value("${donaton.public.centros}")
    private String urlCentros;
    @Value("${donaton.public.donaciones}")
    private String urlDonaciones;
    @Value("${donaton.public.comunas}")
    private String urlComunas;
    @Value("${donaton.public.tipos}")
    private String urlTipos;

    @GetMapping({"/", "/panel"})
    public String panel(Model model) {
        model.addAttribute("resumen", gateway.resumen());
        model.addAttribute("urlDonantes",      urlDonantes);
        model.addAttribute("urlBeneficiarios", urlBeneficiarios);
        model.addAttribute("urlCentros",       urlCentros);
        model.addAttribute("urlDonaciones",    urlDonaciones);
        model.addAttribute("urlComunas",       urlComunas);
        model.addAttribute("urlTipos",         urlTipos);
        return "panel";
    }
}
