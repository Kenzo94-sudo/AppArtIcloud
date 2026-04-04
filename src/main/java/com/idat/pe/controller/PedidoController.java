package com.idat.pe.controller;

import java.util.List;
import java.util.Map;

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
import com.idat.pe.model.Pedidos;
import com.idat.pe.service.PedidoService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping("/listar")
	public List<Pedidos> listar() {
		return service.listar();
	}
	
	@GetMapping("/listar/{idPedido}")
	public ResponseEntity<Pedidos> listarPorId(@PathVariable int idPedido) throws AttributeNotFoundException{
		Pedidos pedido = service.buscarPorId(idPedido);
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("buscar/usuario/{idUsuario}")
	public ResponseEntity<Pedidos> listarPorUsuario(@RequestParam int idUsuario) throws AttributeNotFoundException{
		Pedidos usuario = service.buscarPorId(idUsuario);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Pedidos> guardarPedido(@RequestBody Map<String, Integer> body) throws AttributeNotFoundException{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(body.get("idUsuario"), body.get("idObra")));
	}
	
	@PutMapping("/actualizar/{idPedido}")
	public ResponseEntity<Pedidos> actualizarPedido(@PathVariable int idPedido, @RequestParam Pedidos pedidoDatos) throws AttributeNotFoundException{
		Pedidos pedidoActualizar = service.actualizar(idPedido, pedidoDatos);
		return ResponseEntity.ok(pedidoActualizar);
	}
	
	@DeleteMapping("/eliminar({idPedido}")
	public ResponseEntity<String> eliminarPedido(@PathVariable int idPedido) throws AttributeNotFoundException {
		service.eliminar(idPedido);
		return ResponseEntity.ok("PEDIDO CON ID " + idPedido + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
}
	
