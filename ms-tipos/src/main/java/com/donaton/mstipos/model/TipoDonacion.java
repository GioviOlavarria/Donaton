package com.donaton.mstipos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_donacion")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDonacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La clasificación es obligatoria")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String clasificacion;

    @Size(max = 300)
    @Column(length = 300)
    private String descripcion;
}
