package com.idat.pe.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
>>>>>>> 1709edb (FINAL COMMIT)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.idat.pe.DTO.RegisterRequest;
=======
>>>>>>> 1709edb (FINAL COMMIT)
import com.idat.pe.model.Usuarios;
import com.idat.pe.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
<<<<<<< HEAD
	@GetMapping("/listar")
=======
	@GetMapping("/api/usuarios")
>>>>>>> 1709edb (FINAL COMMIT)
	public List<Usuarios> listar() {
		return service.listar();
	}
	
<<<<<<< HEAD
	@GetMapping("/listar/{idUsuario}")
	public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer idUsuario) throws AttributeNotFoundException {
		Usuarios usuario = service.buscarPorId(idUsuario);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/listar/email/{email}")
=======
	@GetMapping("/api/usuarios/{id}")
	public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer id_usuario) throws AttributeNotFoundException {
		Usuarios usuario = service.buscarPorId(id_usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/api/usuarios/email/{email}")
>>>>>>> 1709edb (FINAL COMMIT)
	public ResponseEntity<Usuarios> buscarPorEmail(@PathVariable String email) {
		Optional<Usuarios> usuario = service.buscarPorEmail(email);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
<<<<<<< HEAD
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
=======
	@PostMapping("/api/usuarios/guardar")
	public ResponseEntity<Usuarios> guardar(@PathVariable Usuarios id_usuario){
		Usuarios usuario = service.guardarUsuario(id_usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/api/usuarios/actualizar/{id}")
	public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable int id_usuario, @RequestBody Usuarios datos) throws AttributeNotFoundException {
		Usuarios usuarioActualizado = service.actualizar(id_usuario, datos);
		return ResponseEntity.ok(usuarioActualizado);
	}
	
	@DeleteMapping("/api/usuarios/borrar/{id}")
	public ResponseEntity<Void> borrarUsuario(@PathVariable int id_usuario) throws AttributeNotFoundException{
		service.eliminar(id_usuario);
		return ResponseEntity.noContent().build();
			
>>>>>>> 1709edb (FINAL COMMIT)
	}
	
}
