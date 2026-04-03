package com.idat.pe.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pago;
import com.idat.pe.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private PagoService service;
	
	@PostMapping("/guardar")
	public ResponseEntity<Pago> guardarPago(@PathVariable Pago pago, int id_usuario, int id_pedido, MetodoPago metodoPago, String estado) throws AttributeNotFoundException
	{
		Pago guardar = service.procesarPago(id_usuario, id_pedido, metodoPago, estado);
		return ResponseEntity.ok(guardar);
	}
	
	@GetMapping("/{id_pago}")
	public ResponseEntity<Pago> listarPorId(@PathVariable int id_pago) throws AttributeNotFoundException
	{
		Pago buscarId = service.buscarPorId(id_pago);
		return ResponseEntity.ok(buscarId);
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<List<Pago>> buscarPorUsuario(@RequestParam int id_usuario) throws AttributeNotFoundException
	{
		List<Pago> buscarUsuario = service.listarPorUsuario(id_usuario);
		return ResponseEntity.ok(buscarUsuario);
	}
	
	@GetMapping("/{id_pedido}")
	public ResponseEntity<Pago> listarPorPedido(@RequestParam int id_pedido) throws AttributeNotFoundException
	{
		Pago buscarPedido = service.buscarPorPedido(id_pedido);
		return ResponseEntity.ok(buscarPedido);
	}
}
