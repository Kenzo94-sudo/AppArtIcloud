package com.idat.pe.controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
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

import com.idat.pe.DTO.PedidoRequest;
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
	
	@GetMapping("/buscar/usuario/{idUsuario}")
	public ResponseEntity<List<Pedidos>> listarPorUsuario(
	    @PathVariable int idUsuario) {
	    List<Pedidos> pedidos = service.listarPorUsuario(idUsuario);
	    return ResponseEntity.ok(pedidos);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crearPedido(@RequestBody PedidoRequest request) {
	    try {
	        Pedidos nuevoPedido = service.procesarPedidoCompleto(request);
	        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
	    } catch (AttributeNotFoundException e) {
	        // Si no encuentra el usuario u obra, mandamos un 404 con el mensaje
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    } catch (Exception e) {
	        // Error genérico
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la compra");
	    }
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
	
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.pe.model.Pedidos;
import com.idat.pe.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // GET /api/pedido/usuario/{id}
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Pedidos>> listarPorUsuario(@PathVariable int id) {
        return ResponseEntity.ok(service.listarPorUsuario(id));
    }

    // POST /api/pedido/crear
    // Body: { "idUsuario": 1, "idObra": 3 }
    @PostMapping("/crear")
    public ResponseEntity<Pedidos> crear(@RequestBody Map<String, Integer> body)
            throws AttributeNotFoundException {
        int idUsuario = body.get("idUsuario");
        int idObra    = body.get("idObra");
        return ResponseEntity.ok(service.crear(idUsuario, idObra));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) throws AttributeNotFoundException {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
>>>>>>> 1709edb (FINAL COMMIT)
