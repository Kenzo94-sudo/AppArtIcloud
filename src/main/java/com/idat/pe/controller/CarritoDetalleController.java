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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.CarritoDetalle;
import com.idat.pe.service.CarritoDetalleService;

@RestController
@RequestMapping("/api/carritoDetalle")
public class CarritoDetalleController {

	@Autowired
	private CarritoDetalleService service;
	
	@GetMapping("/listar")
	public List<CarritoDetalle> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{idCarritoDetalle}")
	public ResponseEntity<CarritoDetalle> listarPorId(@PathVariable int idCarritoDetalle)
	{
		CarritoDetalle detalle = service.buscarPorId(idCarritoDetalle);
		return ResponseEntity.ok(detalle);
	}
	
	@GetMapping("/listar/carrito/{idCarrito}")
	public ResponseEntity<CarritoDetalle> listarPorCarrito(@RequestParam int idCarrito)
	{
		CarritoDetalle carritoDetalleListar = service.listarPorCarrito(idCarrito);
		return ResponseEntity.ok(carritoDetalleListar);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<CarritoDetalle> guardar(@PathVariable CarritoDetalle carritoDetalle)
	{
		CarritoDetalle carritoDetalleGuardar = service.guardarDetalle(carritoDetalle);
		return ResponseEntity.ok(carritoDetalleGuardar);
	}
	
	@PutMapping("/actualizar/{idCarritoDetalle}")
	public ResponseEntity<CarritoDetalle> actualizarDetalle(@PathVariable int idCarritoDetalle, CarritoDetalle carritoDetalleDatos)
	{
		CarritoDetalle carritoDetalleActualizar = service.actualizar(idCarritoDetalle, carritoDetalleDatos);
		return ResponseEntity.ok(carritoDetalleActualizar);
	}
	
	@DeleteMapping("/eliminar/{idCarritoDetalle}")
	public ResponseEntity<String> eliminarDetalle(@PathVariable int idCarritoDetalle)
	{
		service.eliminar(idCarritoDetalle);
		return ResponseEntity.ok("EL DETALLE DE LA COMPRA CON EL ID" + idCarritoDetalle + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
	
}
