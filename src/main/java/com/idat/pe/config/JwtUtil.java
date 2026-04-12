package com.idat.pe.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final static String SECRET_KEY = "clave_secreta";

    public static String generarToken(String email) throws InvalidKeyException {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}