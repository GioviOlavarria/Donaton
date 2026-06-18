package com.donaton.msauth.service;

import com.donaton.msauth.dto.AuthResponse;
import com.donaton.msauth.dto.LoginRequest;
import com.donaton.msauth.dto.RegistroRequest;
import com.donaton.msauth.model.Usuario;
import com.donaton.msauth.repository.UsuarioRepository;
import com.donaton.msauth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public AuthResponse registrar(RegistroRequest req) {
        if (repository.existsByCorreo(req.getCorreo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El correo ya está registrado");
        }
        Usuario usuario = new Usuario();
        usuario.setCorreo(req.getCorreo());
        usuario.setContrasena(passwordEncoder.encode(req.getContrasena()));
        usuario.setRol(req.getRol());
        usuario.setReferenciaId(req.getReferenciaId());
        usuario.setActivo(true);
        Usuario guardado = repository.save(usuario);
        return construirRespuesta(guardado);
    }

    public AuthResponse login(LoginRequest req) {
        Usuario usuario = repository.findByCorreo(req.getCorreo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas"));

        if (Boolean.FALSE.equals(usuario.getActivo())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "La cuenta está deshabilitada");
        }

        if (!passwordEncoder.matches(req.getContrasena(), usuario.getContrasena())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        return construirRespuesta(usuario);
    }

    public boolean validar(String token) {
        return jwtService.esValido(token);
    }

    private AuthResponse construirRespuesta(Usuario usuario) {
        String token = jwtService.generarToken(usuario);
        return new AuthResponse(
                token,
                "Bearer",
                usuario.getId(),
                usuario.getCorreo(),
                usuario.getRol(),
                usuario.getReferenciaId(),
                jwtService.getExpirationMs());
    }
}
