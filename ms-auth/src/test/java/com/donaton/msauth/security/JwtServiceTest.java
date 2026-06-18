package com.donaton.msauth.security;

import com.donaton.msauth.model.Rol;
import com.donaton.msauth.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JwtServiceTest {

    JwtService jwtService;
    Usuario usuario;

    @BeforeEach
    void setUp() {
        // Secret debe tener al menos 32 chars para HMAC-SHA256
        jwtService = new JwtService(
                "clave-super-secreta-de-prueba-1234567890",
                3600000L
        );
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreo("test@test.com");
        usuario.setRol(Rol.DONANTE);
        usuario.setActivo(true);
    }

    @Test
    void generarToken_retornaStringNoVacio() {
        String token = jwtService.generarToken(usuario);
        assertThat(token).isNotBlank();
    }

    @Test
    void esValido_tokenGenerado_retornaTrue() {
        String token = jwtService.generarToken(usuario);
        assertThat(jwtService.esValido(token)).isTrue();
    }

    @Test
    void esValido_tokenFalso_retornaFalse() {
        assertThat(jwtService.esValido("esto.no.es.un.token")).isFalse();
    }

    @Test
    void parse_retornaSubjectCorrecto() {
        String token = jwtService.generarToken(usuario);
        assertThat(jwtService.parse(token).getSubject()).isEqualTo("test@test.com");
    }

    @Test
    void getExpirationMs_retornaValorCorrecto() {
        assertThat(jwtService.getExpirationMs()).isEqualTo(3600000L);
    }
}