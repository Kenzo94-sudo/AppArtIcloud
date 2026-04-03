package com.idat.pe.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Obras;
import com.idat.pe.service.ObraService;
@RestController
@RequestMapping("/api/obras")
public class ObraController {
	
	@Autowired
	private ObraService service;
		
	@GetMapping
	public List<Obras> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Obras> listarPorId(@PathVariable int id) throws AttributeNotFoundException{
		Obras obra = service.buscarPorId(id);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/categoria({id_categoria}")
	public ResponseEntity<List<Obras>> buscarPorCategoria(@RequestParam int id_categoria) throws AttributeNotFoundException{
		List<Obras> obra = service.listarPorCategoria(id_categoria);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Obras>> listarPorTitulo(@RequestParam String titulo) throws AttributeNotFoundException{
		List<Obras> obra = service.buscarPorTitulo(titulo);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/precio")
	public ResponseEntity<List<Obras>> buscarPorPrecio(@RequestParam float precio) throws AttributeNotFoundException{
		List<Obras> obra = service.filtrarPorPrecio(precio, precio);
		return ResponseEntity.ok(obra);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Obras> guardarObras(@PathVariable Obras obra) throws AttributeNotFoundException{
		Obras obraGuardar = service.guardar(obra);
		return ResponseEntity.ok(obraGuardar);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Obras> actualizarObra(@PathVariable int id_obra, @RequestParam Obras datos) throws AttributeNotFoundException{
		Obras obraActualizar = service.actualizar(id_obra, datos);
		return ResponseEntity.ok(obraActualizar);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Void> eliminarObra(@PathVariable int id_obra) throws AttributeNotFoundException {
		service.eliminar(id_obra);
		return ResponseEntity.noContent().build();
	}
}
