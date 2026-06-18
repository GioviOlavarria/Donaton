package com.donaton.mscomunas.controller;

import com.donaton.mscomunas.service.ComunaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ComunaControllerTest {

    @Autowired ComunaController controller;
    @MockitoBean ComunaService service;

    @Test
    void controllerCargaCorrectamente() {
        assertThat(controller).isNotNull();
    }
}
