package com.idat.pe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository repository;

    public AuthService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> login(String email, String password) {
        Usuarios usuario = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password))
            throw new RuntimeException("Contraseña incorrecta");

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idUsuario", usuario.getIdUsuario());
        respuesta.put("nombre", usuario.getNombre());
        respuesta.put("email", usuario.getEmail());
        respuesta.put("mensaje", "Login exitoso");
        return respuesta;
    }

    public Map<String, Object> recuperarPassword(String email) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email no registrado"));

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se enviaron instrucciones al correo: " + email);
        return respuesta;
    }
}