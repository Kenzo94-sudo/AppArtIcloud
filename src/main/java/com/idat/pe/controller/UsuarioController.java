package com.idat.pe.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Usuarios;
import com.idat.pe.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuarios> listar() {
		return service.listar();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer id_usuario) throws AttributeNotFoundException {
		Usuarios usuario = service.buscarPorId(id_usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Usuarios> buscarPorEmail(@PathVariable String email) {
		Optional<Usuarios> usuario = service.buscarPorEmail(email);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuarios> guardar(@PathVariable Usuarios id_usuario){
		Usuarios usuario = service.guardarUsuario(id_usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable int id_usuario, @RequestBody Usuarios datos) throws AttributeNotFoundException {
		Usuarios usuarioActualizado = service.actualizar(id_usuario, datos);
		return ResponseEntity.ok(usuarioActualizado);
	}
	
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<Void> borrarUsuario(@PathVariable int id_usuario) throws AttributeNotFoundException{
		service.eliminar(id_usuario);
		return ResponseEntity.noContent().build();
			
	}
	
}
