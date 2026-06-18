package com.donaton.msauth.service;

import com.donaton.msauth.dto.AuthResponse;
import com.donaton.msauth.dto.LoginRequest;
import com.donaton.msauth.dto.RegistroRequest;
import com.donaton.msauth.model.Rol;
import com.donaton.msauth.model.Usuario;
import com.donaton.msauth.repository.UsuarioRepository;
import com.donaton.msauth.security.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock UsuarioRepository repository;
    @Mock PasswordEncoder passwordEncoder;
    @Mock JwtService jwtService;
    @InjectMocks AuthService service;

    Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreo("test@test.com");
        usuario.setContrasena("hashed");
        usuario.setRol(Rol.DONANTE);
        usuario.setActivo(true);
    }

    @Test
    void registrar_correoNuevo_retornaToken() {
        RegistroRequest req = new RegistroRequest();
        req.setCorreo("nuevo@test.com");
        req.setContrasena("123456");
        req.setRol(Rol.DONANTE);

        when(repository.existsByCorreo("nuevo@test.com")).thenReturn(false);
        when(passwordEncoder.encode("123456")).thenReturn("hashed");
        when(repository.save(any())).thenReturn(usuario);
        when(jwtService.generarToken(any())).thenReturn("token123");
        when(jwtService.getExpirationMs()).thenReturn(3600000L);

        AuthResponse resp = service.registrar(req);
        assertThat(resp.getToken()).isEqualTo("token123");
    }

    @Test
    void registrar_correoDuplicado_lanzaExcepcion() {
        RegistroRequest req = new RegistroRequest();
        req.setCorreo("test@test.com");
        req.setContrasena("123456");
        req.setRol(Rol.DONANTE);

        when(repository.existsByCorreo("test@test.com")).thenReturn(true);
        assertThatThrownBy(() -> service.registrar(req))
                .isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void login_credencialesValidas_retornaToken() {
        LoginRequest req = new LoginRequest();
        req.setCorreo("test@test.com");
        req.setContrasena("password");

        when(repository.findByCorreo("test@test.com")).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("password", "hashed")).thenReturn(true);
        when(jwtService.generarToken(usuario)).thenReturn("tokenOk");
        when(jwtService.getExpirationMs()).thenReturn(3600000L);

        AuthResponse resp = service.login(req);
        assertThat(resp.getToken()).isEqualTo("tokenOk");
    }

    @Test
    void login_contrasenaIncorrecta_lanzaExcepcion() {
        LoginRequest req = new LoginRequest();
        req.setCorreo("test@test.com");
        req.setContrasena("mala");

        when(repository.findByCorreo("test@test.com")).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("mala", "hashed")).thenReturn(false);

        assertThatThrownBy(() -> service.login(req))
                .isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void login_usuarioDesactivado_lanzaExcepcion() {
        usuario.setActivo(false);
        LoginRequest req = new LoginRequest();
        req.setCorreo("test@test.com");
        req.setContrasena("password");

        when(repository.findByCorreo("test@test.com")).thenReturn(Optional.of(usuario));

        assertThatThrownBy(() -> service.login(req))
                .isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void validar_tokenValido_retornaTrue() {
        when(jwtService.esValido("tokenOk")).thenReturn(true);
        assertThat(service.validar("tokenOk")).isTrue();
    }

    @Test
    void validar_tokenInvalido_retornaFalse() {
        when(jwtService.esValido("bad")).thenReturn(false);
        assertThat(service.validar("bad")).isFalse();
    }
}