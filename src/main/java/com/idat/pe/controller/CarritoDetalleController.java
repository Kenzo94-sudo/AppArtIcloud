package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.CarritoDetalle;
import com.idat.pe.service.CarritoDetalleService;

@RestController
@RequestMapping("/api/Detalle")
public class CarritoDetalleController {

	@Autowired
	private CarritoDetalleService service;
	
	@GetMapping
	public List<CarritoDetalle> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id_detalle}")
	public ResponseEntity<CarritoDetalle> listarPorId(@PathVariable int id_detalle)
	{
		CarritoDetalle detalle = service.buscarPorId(id_detalle);
		return ResponseEntity.ok(detalle);
	}
	
	@GetMapping("/{id_carrito}")
	public ResponseEntity<CarritoDetalle> listarPorCarrito(@PathVariable int id_carrito)
	{
		CarritoDetalle detalle = service.listarPorCarrito(id_carrito);
		return ResponseEntity.ok(detalle);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<CarritoDetalle> guardar(@PathVariable CarritoDetalle carritoDetalle)
	{
		CarritoDetalle detalle1 = service.guardarDetalle(carritoDetalle);
		return ResponseEntity.ok(detalle1);
	}
	
	@PutMapping("/actualizar/{id_detalle}")
	public ResponseEntity<CarritoDetalle> actualizarDetalle(@PathVariable int id_detalle, CarritoDetalle datos)
	{
		CarritoDetalle cDetalle = service.actualizar(id_detalle, datos);
		return ResponseEntity.ok(cDetalle);
	}
	
	@DeleteMapping("/eliminar/{id_detalle}")
	public ResponseEntity<Void> eliminarDetalle(@PathVariable int id_detalle)
	{
		service.eliminar(id_detalle);
		return ResponseEntity.noContent().build();
	}
	
}
