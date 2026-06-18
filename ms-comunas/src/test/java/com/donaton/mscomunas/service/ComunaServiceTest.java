package com.donaton.mscomunas.service;

import com.donaton.mscomunas.model.Comuna;
import com.donaton.mscomunas.repository.ComunaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComunaServiceTest {

    @Mock ComunaRepository repository;
    @InjectMocks ComunaService service;

    Comuna comuna;

    @BeforeEach
    void setUp() {
        comuna = new Comuna();
        comuna.setId(1L);
        comuna.setNombre("Santiago");
    }

    @Test
    void listarTodas_retornaLista() {
        when(repository.findAllByOrderByNombreAsc()).thenReturn(List.of(comuna));
        assertThat(service.listarTodas()).hasSize(1);
    }

    @Test
    void buscarPorNombre_retornaFiltrado() {
        when(repository.findByNombreContainingIgnoreCaseOrderByNombreAsc("san"))
                .thenReturn(List.of(comuna));
        assertThat(service.buscarPorNombre("san")).containsExactly(comuna);
    }

    @Test
    void buscarPorId_encontrado() {
        when(repository.findById(1L)).thenReturn(Optional.of(comuna));
        assertThat(service.buscarPorId(1L)).isEqualTo(comuna);
    }

    @Test
    void buscarPorId_noEncontrado_lanzaExcepcion() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.buscarPorId(99L))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void guardar_llama_save() {
        when(repository.save(comuna)).thenReturn(comuna);
        assertThat(service.guardar(comuna)).isEqualTo(comuna);
    }

    @Test
    void actualizar_cambiaNombre() {
        Comuna datos = new Comuna(); datos.setNombre("Providencia");
        when(repository.findById(1L)).thenReturn(Optional.of(comuna));
        when(repository.save(comuna)).thenReturn(comuna);
        service.actualizar(1L, datos);
        assertThat(comuna.getNombre()).isEqualTo("Providencia");
    }

    @Test
    void eliminar_llamaDelete() {
        when(repository.findById(1L)).thenReturn(Optional.of(comuna));
        service.eliminar(1L);
        verify(repository).delete(comuna);
    }
}