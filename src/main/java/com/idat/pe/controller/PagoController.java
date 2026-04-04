package com.idat.pe.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Pago> guardarPago(@RequestBody Pago pago, int idUsuario, int idPedido, MetodoPago metodoPago, String estado) throws AttributeNotFoundException
	{
		Pago guardar = service.procesarPago(idUsuario, idPedido, metodoPago, estado);
		return ResponseEntity.ok(guardar);
	}
	
	@GetMapping("/listar/{idPago}")
	public ResponseEntity<Pago> listarPorId(@PathVariable int idPago) throws AttributeNotFoundException
	{
		Pago buscarIdPago = service.buscarPorId(idPago);
		return ResponseEntity.ok(buscarIdPago);
	}
	
	@GetMapping("/buscar/{idUsuario}")
	public ResponseEntity<List<Pago>> buscarPorUsuario(@RequestParam int idUsuario) throws AttributeNotFoundException
	{
		List<Pago> buscarUsuario = service.listarPorUsuario(idUsuario);
		return ResponseEntity.ok(buscarUsuario);
	}
	
	@GetMapping("/listar/{idPedido}")
	public ResponseEntity<Pago> listarPorPedido(@RequestParam int idPedido) throws AttributeNotFoundException
	{
		Pago buscarPedido = service.buscarPorPedido(idPedido);
		return ResponseEntity.ok(buscarPedido);
	}
}
