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

import com.idat.pe.model.PedidoDetalle;
import com.idat.pe.service.PedidosDetalleService;

@RestController
@RequestMapping("/api/detalle")
public class PedidoDetalleController {
	
	@Autowired
	private PedidosDetalleService service;
	
	@GetMapping
	public List<PedidoDetalle> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id_detalle}")
	public ResponseEntity<PedidoDetalle> lisarPorId(@PathVariable int id_detalle) throws AttributeNotFoundException {
		PedidoDetalle detalle = service.buscarPorId(id_detalle);
		return ResponseEntity.ok(detalle);
	}
	
	@PostMapping("/guardar/{id_detalle}")
	public ResponseEntity<PedidoDetalle> guardarPedidoDetalle(@PathVariable PedidoDetalle id_detalle){
		PedidoDetalle detalle = service.guardarDetalle(id_detalle);
		return ResponseEntity.ok(detalle);
	}
	
	
	@PutMapping("/actualizar")
	public ResponseEntity<PedidoDetalle> actualizarPedidoDetalle(@PathVariable int id_detalle, @RequestParam PedidoDetalle datos) throws AttributeNotFoundException {
		PedidoDetalle detallePedido = service.actualizarDetalle(id_detalle, datos);
		return ResponseEntity.ok(detallePedido);
	}
	
	@DeleteMapping("/eliminar/{id_detalle}")
	public ResponseEntity<Void> eliminarDetalle(@PathVariable int id_detalle) throws AttributeNotFoundException{
		service.eliminar(id_detalle);
		return ResponseEntity.noContent().build();
	}
}
