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
@RequestMapping("/api/carrito")
public class CarritoController {
	
		@Autowired
		private CarritoService service;
		
		@GetMapping("/listar")
		public List<Carrito> listar()
		{
			return service.listar();
		}
		
		@GetMapping("/listar/{idCarrito}")
		public ResponseEntity<Carrito> listarPorId(@PathVariable int idCarrito)
		{
			Carrito buscarIdCarrito = service.buscarPorId(idCarrito);
			return ResponseEntity.ok(buscarIdCarrito);
		}
		
		@GetMapping("/listar/{idUsuario}")
		public ResponseEntity<Carrito> listarPorUsuario(@PathVariable int idUsuario)
		{
			Carrito buscarUsuario = service.buscarPorUsuario(idUsuario);
			return ResponseEntity.ok(buscarUsuario);
		}
		
		@GetMapping("/listar/carrito/{idUsuario}")
		public ResponseEntity<Carrito> obtener(@PathVariable int idUsuario)
		{
			return ResponseEntity.ok(service.obtenerOCrear(idUsuario));
		}
		
		
		@PostMapping("/guardar")
		public ResponseEntity<Carrito> guardar(@PathVariable Carrito carrito)
		{
			Carrito guardarCarrito = service.guardarCompra(carrito);
			return ResponseEntity.ok(guardarCarrito);
		}
		
		
		@DeleteMapping("/eliminar/{idCarrito}")
		public ResponseEntity<String> eliminar(int idCarrito)
		{
			service.eliminar(idCarrito);
			return ResponseEntity.ok("LA COMPRA CON EL ID" + idCarrito + "HA SIDO ELIMINADO EXITOSAMENTE");
		}
}
