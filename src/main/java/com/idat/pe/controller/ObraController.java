package com.idat.pe.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idat.pe.model.Obras;
import com.idat.pe.service.ObraService;

public class ObraController {
	
	@Autowired
	private ObraService service;
		
	@GetMapping("/api/obra")
	public List<Obras> listar(){
		return service.listar();
	}
	
	@GetMapping("/api/obra/{id}")
	public ResponseEntity<Obras> buscarPorId(@PathVariable int id) throws AttributeNotFoundException{
		Obras obra = service.buscarPorId(id);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/api/obra/titulo")
	public ResponseEntity<List<Obras>> buscarPorTitulo(@RequestParam String titulo) throws AttributeNotFoundException{
		List<Obras> obra = service.buscarPorTitulo(titulo);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/api/obra/precio")
	public ResponseEntity<List<Obras>> buscarPorPrecio(@RequestParam float precio) throws AttributeNotFoundException{
		List<Obras> obra = service.filtrarPorPrecio(precio, precio);
		return ResponseEntity.ok(obra);
	}
	
	@PostMapping("/api/obra/guardar")
	public ResponseEntity<Obras> guardarObras(@PathVariable Obras obra) throws AttributeNotFoundException{
		Obras obraGuardar = service.guardar(obra);
		return ResponseEntity.ok(obraGuardar);
	}
}
