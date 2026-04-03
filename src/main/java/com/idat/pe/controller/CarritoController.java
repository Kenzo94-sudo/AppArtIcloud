package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Carrito;
import com.idat.pe.service.CarritoService;

@RestController
@RequestMapping("/api/Carrito")
public class CarritoController {
	
		@Autowired
		private CarritoService service;
		
		@GetMapping("/usuario")
		public List<Carrito> listar()
		{
			return service.listar();
		}
		
		@GetMapping("/usuario/{id_carrito}")
		public ResponseEntity<Carrito> listarPorId(@PathVariable int id_carrito)
		{
			Carrito buscarId = service.buscarPorId(id_carrito);
			return ResponseEntity.ok(buscarId);
		}
		
		@GetMapping("/usuario/{id_usuario}")
		public ResponseEntity<Carrito> listarPorUsuario(@PathVariable int id_usuario)
		{
			Carrito buscarUsuario = service.buscarPorUsuario(id_usuario);
			return ResponseEntity.ok(buscarUsuario);
		}
		
		@GetMapping("/usuario/{íd_usuario}")
		public ResponseEntity<Carrito> obtener(@PathVariable int id_usuario)
		{
			return ResponseEntity.ok(service.obtenerOCrear(id_usuario));
		}
		
		
		@PostMapping("/guardar")
		public ResponseEntity<Carrito> guardar(@PathVariable Carrito carrito)
		{
			Carrito guardarCarrito = service.guardarCompra(carrito);
			return ResponseEntity.ok(guardarCarrito);
		}
		
		
		@DeleteMapping("/eliminar")
		public ResponseEntity<Void> eliminar(int id)
		{
			service.eliminar(id);
			return ResponseEntity.noContent().build();
		}
}
