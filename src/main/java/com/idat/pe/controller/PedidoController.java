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
	
	@GetMapping
	public List<Pedidos> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id_pedido}")
	public ResponseEntity<Pedidos> listarPorId(@PathVariable int id_pedido) throws AttributeNotFoundException{
		Pedidos pedido = service.buscarPorId(id_pedido);
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("/usuario/{id_usuario}")
	public ResponseEntity<Pedidos> listarPorUsuario(@RequestParam int id_usuario) throws AttributeNotFoundException{
		Pedidos usuario = service.buscarPorId(id_usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Pedidos> guardarPedido(@RequestBody Map<String, Integer> body) throws AttributeNotFoundException{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(body.get("id_usuario"), body.get("id_obra")));
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Pedidos> actualizarPedido(@PathVariable int id_pedido,@RequestParam Pedidos datos) throws AttributeNotFoundException{
		Pedidos pedidoActualizar = service.actualizar(id_pedido, datos);
		return ResponseEntity.ok(pedidoActualizar);
	}
	
	@DeleteMapping("/eliminar({id_pedido}")
	public ResponseEntity<Void> eliminarPedido(@PathVariable int id_pedido) throws AttributeNotFoundException {
		service.eliminar(id_pedido);
		return ResponseEntity.noContent().build();
	}
}
	
