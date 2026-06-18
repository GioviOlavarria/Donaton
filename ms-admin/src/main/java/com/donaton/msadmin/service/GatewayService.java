package com.donaton.msadmin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GatewayService {

    private final RestClient restClient;

    @Value("${donaton.services.donantes}")
    private String donantesUrl;
    @Value("${donaton.services.beneficiarios}")
    private String beneficiariosUrl;
    @Value("${donaton.services.centros}")
    private String centrosUrl;
    @Value("${donaton.services.donaciones}")
    private String donacionesUrl;
    @Value("${donaton.services.comunas}")
    private String comunasUrl;
    @Value("${donaton.services.tipos}")
    private String tiposUrl;

    private static final ParameterizedTypeReference<List<Map<String, Object>>> LIST_MAP =
            new ParameterizedTypeReference<>() {};

    public List<Map<String, Object>> obtenerLista(String url) {
        try {
            List<Map<String, Object>> respuesta = restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(LIST_MAP);
            return respuesta == null ? List.of() : respuesta;
        } catch (Exception e) {
            return List.of();
        }
    }

    public int contar(String url) {
        return obtenerLista(url).size();
    }

    public Map<String, Object> resumen() {
        return Map.of(
                "donantes",     contar(donantesUrl + "/api/donantes"),
                "beneficiarios", contar(beneficiariosUrl + "/api/beneficiantes"),
                "centros",      contar(centrosUrl + "/api/centros"),
                "donaciones",   contar(donacionesUrl + "/api/donaciones"),
                "comunas",      contar(comunasUrl + "/api/comunas"),
                "tiposDonacion", contar(tiposUrl + "/api/tipos-donacion"),
                "tiposBeneficiante", contar(tiposUrl + "/api/tipos-beneficiante"));
    }
}
