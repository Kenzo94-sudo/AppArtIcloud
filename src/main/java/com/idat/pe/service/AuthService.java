package com.idat.pe.service;

import java.util.HashMap;
import java.util.Map;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.config.JwtUtil;
=======
import org.springframework.stereotype.Service;

>>>>>>> 1709edb (FINAL COMMIT)
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.UsuarioRepository;

@Service
public class AuthService {
<<<<<<< HEAD
	@Autowired
    private final UsuarioRepository repository;
	@Autowired
	private JwtUtil jwtUtil;
=======

    private final UsuarioRepository repository;
>>>>>>> 1709edb (FINAL COMMIT)

    public AuthService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> login(String email, String password) throws AttributeNotFoundException {
<<<<<<< HEAD
    	// PASO 1 — Busca el usuario en la BD por email
    	Usuarios usuario = repository.findByEmail(email)
                .orElseThrow(() -> new AttributeNotFoundException("Usuario no encontrado"));
       
    	// PASO 2 — Verifica que la contraseña sea correcta
        if (!usuario.getPassword().equals(password))
            throw new RuntimeException("Contraseña incorrecta");
        
        // PASO 3 — Genera el token JWT
        String token = JwtUtil.generarToken(usuario.getEmail());

        // PASO 4 — Devuelve token + datos del usuario
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("token", token);
=======
        Usuarios usuario = repository.findByEmail(email)
                .orElseThrow(() -> new AttributeNotFoundException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password))
            throw new RuntimeException("Contraseña incorrecta");

        Map<String, Object> respuesta = new HashMap<>();
>>>>>>> 1709edb (FINAL COMMIT)
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