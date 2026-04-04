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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.PedidoDetalle;
import com.idat.pe.service.PedidosDetalleService;

@RestController
@RequestMapping("/api/pedidoDetalle")
public class PedidoDetalleController {
	
	@Autowired
	private PedidosDetalleService service;
	
	@GetMapping("/listar")
	public List<PedidoDetalle> listar() {
		return service.listar();
	}
	
	@GetMapping("/listar/{idPedidoDetalle}")
	public ResponseEntity<PedidoDetalle> lisarPorId(@PathVariable int idPedidoDetalle) throws AttributeNotFoundException {
		PedidoDetalle detallePedido = service.buscarPorId(idPedidoDetalle);
		return ResponseEntity.ok(detallePedido);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<PedidoDetalle> guardarPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle){
		PedidoDetalle pedidoDetalleEliminar = service.guardarDetalle(pedidoDetalle);
		return ResponseEntity.ok(pedidoDetalleEliminar);
	}
	
	
	@PutMapping("/actualizar/{idPedidoDetalle}")
	public ResponseEntity<PedidoDetalle> actualizarPedidoDetalle(@PathVariable int idPedidoDetalle, @RequestParam PedidoDetalle pedidoDatos) throws AttributeNotFoundException {
		PedidoDetalle pedidoDetalleActualizar = service.actualizarDetalle(idPedidoDetalle, pedidoDatos);
		return ResponseEntity.ok(pedidoDetalleActualizar);
	}
	
	@DeleteMapping("/eliminar/{idPedidoDetalle}")
	public ResponseEntity<String> eliminarDetalle(@PathVariable int idPedidoDetalle) throws AttributeNotFoundException{
		service.eliminar(idPedidoDetalle);
		return ResponseEntity.ok("EL DETALLE DEL PEDIDO CON ID " + idPedidoDetalle + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
}
