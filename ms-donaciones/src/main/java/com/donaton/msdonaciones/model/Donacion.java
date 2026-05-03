package com.donaton.msdonaciones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "donacion")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El donante es obligatorio")
    @Column(name = "donante_id", nullable = false)
    private Long donanteId;

    @NotNull(message = "El beneficiario es obligatorio")
    @Column(name = "beneficiario_id", nullable = false)
    private Long beneficiarioId;

    @NotNull(message = "El centro de acopio es obligatorio")
    @Column(name = "centro_acopio_id", nullable = false)
    private Long centroAcopioId;

    @NotBlank(message = "La descripción del artículo es obligatoria")
    @Size(max = 255)
    @Column(nullable = false)
    private String articulo;

    @Positive(message = "La cantidad debe ser mayor a cero")
    @Column(nullable = false)
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoDonacion estado = EstadoDonacion.PENDIENTE;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en")
    private LocalDateTime actualizadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.actualizadoEn = LocalDateTime.now();
    }
}