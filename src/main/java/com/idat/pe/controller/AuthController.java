package com.idat.pe.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.config.JwtUtil;
import com.idat.pe.model.LoginRequest;
import com.idat.pe.model.Usuarios;
import com.idat.pe.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		
		//Validar credenciales
		Usuarios usuario = service.autenticar(request.getEmail(), request.getPassword());
		
		//Generar token
		String token = jwtUtil.generarToken(request.getEmail());
		
		//Retorna respuesta
		return ResponseEntity.ok(Map.of(
				"token", token,
				"idUsuario", usuario.getId_usuario(),
				"nombre", usuario.getNombre(),
				"email", usuario.getEmail()
				));
	}
}
