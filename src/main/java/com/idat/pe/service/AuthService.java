package com.idat.pe.service;

import java.util.HashMap;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.config.JwtUtil;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.UsuarioRepository;

@Service
public class AuthService {
	@Autowired
    private final UsuarioRepository repository;
	@Autowired
	private JwtUtil jwtUtil;

    public AuthService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> login(String email, String password) throws AttributeNotFoundException {
        Usuarios usuario = repository.findByEmail(email)
                .orElseThrow(() -> new AttributeNotFoundException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password))
            throw new RuntimeException("Contraseña incorrecta");
        
        String token = JwtUtil.generarToken(usuario.getEmail());

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idUsuario", usuario.getId_usuario());
        respuesta.put("nombre", usuario.getNombre());
        respuesta.put("email", usuario.getEmail());
        respuesta.put("mensaje", "Login exitoso");
        return respuesta;
    }

    public Map<String, Object> recuperarPassword(String email) throws AttributeNotFoundException {
        Usuarios usuario = repository.findByEmail(email)
                .orElseThrow(() -> new AttributeNotFoundException("Email no registrado"));

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se enviaron instrucciones al correo: " + email);
        return respuesta;
    }
}