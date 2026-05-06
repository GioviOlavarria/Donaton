package com.donaton.msbeneficiarios.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "beneficiario")
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String apellido;

    @NotBlank(message = "El RUT es obligatorio")
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String rut;

    @Size(max = 20)
    private String telefono;


    @Column(columnDefinition = "TEXT")
    private String necesidad;


    @NotNull(message = "El centro de acopio es obligatorio")
    @Column(name = "centro_acopio_id", nullable = false)
    private Long centroAcopioId;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }
}
