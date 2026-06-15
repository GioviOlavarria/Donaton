package com.donaton.msauth.security;

import com.donaton.msauth.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtService {

    private final SecretKey key;
    private final long expirationMs;

    public JwtService(
            @Value("${donaton.jwt.secret}") String secret,
            @Value("${donaton.jwt.expiration-ms}") long expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    public String generarToken(Usuario usuario) {
        Date ahora = new Date();
        Date expira = new Date(ahora.getTime() + expirationMs);
        return Jwts.builder()
                .subject(usuario.getCorreo())
                .claims(Map.of(
                        "uid", usuario.getId(),
                        "rol", usuario.getRol().name(),
                        "referenciaId", usuario.getReferenciaId() == null ? 0 : usuario.getReferenciaId()))
                .issuedAt(ahora)
                .expiration(expira)
                .signWith(key)
                .compact();
    }

    public Claims parse(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean esValido(String token) {
        try {
            parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public long getExpirationMs() {
        return expirationMs;
    }
}
