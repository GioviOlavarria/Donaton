package com.donaton.mscentrosacopio.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RelacionMicroserviciosClient {

    @Value("${donaton.services.donantes-url}")
    private String donantesUrl;

    @Value("${donaton.services.donaciones-url}")
    private String donacionesUrl;

    @Value("${donaton.services.beneficiarios-url}")
    private String beneficiariosUrl;

    public void eliminarDatosAsociadosAlCentro(Long centroId) {
        RestClient.create()
                .delete()
                .uri(donacionesUrl + "/api/donaciones/centro/" + centroId)
                .retrieve()
                .toBodilessEntity();

        RestClient.create()
                .delete()
                .uri(donantesUrl + "/api/donantes/centro/" + centroId)
                .retrieve()
                .toBodilessEntity();

        RestClient.create()
                .delete()
                .uri(beneficiariosUrl + "/api/beneficiarios/centro/" + centroId)
                .retrieve()
                .toBodilessEntity();
    }
}
