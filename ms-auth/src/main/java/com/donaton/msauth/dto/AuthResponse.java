package com.donaton.msauth.dto;

import com.donaton.msauth.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String tipo;
    private Long usuarioId;
    private String correo;
    private Rol rol;
    private Long referenciaId;
    private long expiraEnMs;
}
