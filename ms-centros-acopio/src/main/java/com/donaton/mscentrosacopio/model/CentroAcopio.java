package com.donaton.mscentrosacopio.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "centro_acopio")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class CentroAcopio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message= "La dirección es obligatoria.")
    @Size(max = 100, message= "La dirección no puede tener más de 100 caracteres.)")
    @Column(nullable = false, length = 100)
    private String direccion;

    @Size(max = 100)
    private String comuna;


    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max=12)
    @Column(nullable = false, length = 12)
    private String telefono;

    @Email(message = "El email no tiene un formato válido")
    @Size(max = 150)
    private String email;

    @Column(nullable = false)
    private Boolean activo = true;


    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }

}
