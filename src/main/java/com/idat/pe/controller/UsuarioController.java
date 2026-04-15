package com.idat.pe.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.DTO.RegisterRequest;
import com.idat.pe.model.Usuarios;
import com.idat.pe.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/listar")
	public List<Usuarios> listar() {
		return service.listar();
	}
	
	@GetMapping("/listar/{idUsuario}")
	public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer idUsuario) throws AttributeNotFoundException {
		Usuarios usuario = service.buscarPorId(idUsuario);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/listar/email/{email}")
	public ResponseEntity<Usuarios> buscarPorEmail(@PathVariable String email) {
		Optional<Usuarios> usuario = service.buscarPorEmail(email);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody RegisterRequest request) {
	    try {
	        Usuarios usuarioCreado = service.registrarNuevoUsuario(request);
	        return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: El correo ya existe");
	    }
	}
	
	@PutMapping("/actualizar/{idUsuario}")
	public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable int idUsuario, @RequestBody Usuarios usuarioDatos) throws AttributeNotFoundException {
		Usuarios usuarioActualizado = service.actualizar(idUsuario, usuarioDatos);
		return ResponseEntity.ok(usuarioActualizado);
	}
	
	@DeleteMapping("/borrar/{idUsuario}")
	public ResponseEntity<String> borrarUsuario(@PathVariable int idUsuario) throws AttributeNotFoundException{
		service.eliminar(idUsuario);
		return ResponseEntity.ok("USUARIO CON ID " + idUsuario + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
	
}
