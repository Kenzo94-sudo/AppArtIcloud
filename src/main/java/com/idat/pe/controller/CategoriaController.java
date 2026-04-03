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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Categorias;
import com.idat.pe.service.CategoriaService;
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	
	@GetMapping
	public List<Categorias> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> listarPorId(@PathVariable int id) throws AttributeNotFoundException{
		Categorias categoria = service.buscarPorId(id);
		return ResponseEntity.ok(categoria);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Categorias> guardarCategoria(@PathVariable Categorias id_categoria) throws AttributeNotFoundException{
		Categorias categoria = service.guardar(id_categoria);
		return ResponseEntity.ok(categoria);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Categorias> actualizarCategoria(@PathVariable int id_categoria, @RequestBody Categorias datos) throws AttributeNotFoundException{
		Categorias categoria = service.actualizar(id_categoria, datos);
		return ResponseEntity.ok(categoria);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminarCategoria(@PathVariable int id_categoria) throws AttributeNotFoundException{
		service.eliminar(id_categoria);
		return ResponseEntity.noContent().build();
	}
}
