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
	
	
	@GetMapping("/listar")
	public List<Categorias> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{idCategoria}")
	public ResponseEntity<Categorias> listarPorId(@PathVariable int idCategoria) throws AttributeNotFoundException{
		Categorias categoria = service.buscarPorId(idCategoria);
		return ResponseEntity.ok(categoria);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Categorias> guardarCategoria(@PathVariable Categorias idCategoria) throws AttributeNotFoundException{
		Categorias categoria = service.guardar(idCategoria);
		return ResponseEntity.ok(categoria);
	}
	
	@PutMapping("/actualizar/{idCategoria}")
	public ResponseEntity<Categorias> actualizarCategoria(@PathVariable int idCategoria, @RequestBody Categorias categoriaDatos) throws AttributeNotFoundException{
		Categorias categoria = service.actualizar(idCategoria, categoriaDatos);
		return ResponseEntity.ok(categoria);
	}
	
	@DeleteMapping("/eliminar/{idCategoria}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable int idCategoria) throws AttributeNotFoundException{
		service.eliminar(idCategoria);
		return ResponseEntity.ok("LA CATEGORIA DE LA OBRA" + idCategoria + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
}
