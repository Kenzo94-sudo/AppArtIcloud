package com.idat.pe.controller;

import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.pe.model.Usuarios;
import com.idat.pe.service.AuthService;
import com.idat.pe.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AutenticacionController {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    public AutenticacionController(AuthService authService, UsuarioService usuarioService) {
        this.authService = authService;
        this.usuarioService = usuarioService;
    }

    // POST /api/auth/login
    // Body: { "email": "ana@mail.com", "password": "12345678" }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body)
            throws AttributeNotFoundException {
        String email    = body.get("email");
        String password = body.get("password");
        Map<String, Object> respuesta = authService.login(email, password);
        return ResponseEntity.ok(respuesta);
    }

    // POST /api/auth/register
    // Body: { "nombre": "Ana", "email": "ana@mail.com", "password": "12345678" }
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Usuarios usuario) {
        Usuarios saved = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(Map.of(
            "idUsuario", saved.getId_usuario(),
            "nombre",    saved.getNombre(),
            "email",     saved.getEmail(),
            "mensaje",   "Registro exitoso"
        ));
    }
}