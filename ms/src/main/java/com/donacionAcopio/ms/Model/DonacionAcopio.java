package com.donacionAcopio.ms.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DonacionAcopio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "donacionId", nullable = false)
    private Long donacionId;

    @Column(name = "acopioId", nullable = false)
    private Long acopioId;

    @Column(name = "fechaCreacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "estado", nullable = false)
    private String estado;
}
