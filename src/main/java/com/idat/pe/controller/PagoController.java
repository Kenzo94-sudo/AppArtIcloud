package com.idat.pe.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.DTO.PagoRequest;
import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pagos;
import com.idat.pe.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private PagoService service;
	
	@PostMapping("/procesar")
    public ResponseEntity<?> realizarPago(@RequestBody PagoRequest request) {
        try {
            service.procesarPago(request);
            return ResponseEntity.ok("Pago procesado exitosamente y pedido actualizado");
        } catch (AttributeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error en la pasarela de pago");
     }
	}
	
	@GetMapping("/listar/{idPago}")
	public ResponseEntity<Pagos> listarPorId(@PathVariable int idPago) throws AttributeNotFoundException
	{
		Pagos buscarIdPago = service.buscarPorId(idPago);
		return ResponseEntity.ok(buscarIdPago);
	}
	
	@GetMapping("/buscar/{idUsuario}")
	public ResponseEntity<List<Pagos>> buscarPorUsuario(@RequestParam int idUsuario) throws AttributeNotFoundException
	{
		List<Pagos> buscarUsuario = service.listarPorUsuario(idUsuario);
		return ResponseEntity.ok(buscarUsuario);
	}
	
	@GetMapping("/listar/{idPedido}")
	public ResponseEntity<Pagos> listarPorPedido(@RequestParam int idPedido) throws AttributeNotFoundException
	{
		Pagos buscarPedido = service.buscarPorPedido(idPedido);
		return ResponseEntity.ok(buscarPedido);
	}
}
