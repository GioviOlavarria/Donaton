package com.donaton.mstipos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_beneficiante")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoBeneficiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String categoria;
}
