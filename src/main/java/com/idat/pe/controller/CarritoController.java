package com.idat.pe.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Carrito;

import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.pe.model.CarritoDetalle;

import com.idat.pe.service.CarritoService;

@RestController
@RequestMaping("/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    private final CarritoService service;

    public CarritoController(CarritoService service) {
        this.service = service;
    }

    // GET /api/carrito/{idUsuario}
    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<CarritoDetalle>> obtenerCarrito(@PathVariable int idUsuario)
            throws AttributeNotFoundException {
        return ResponseEntity.ok(service.obtenerItems(idUsuario));
    }

    // POST /api/carrito/agregar
    // Body: { "idUsuario": 1, "idObra": 2, "cantidad": 1 }
    @PostMapping("/agregar")
    public ResponseEntity<CarritoDetalle> agregar(@RequestBody Map<String, Integer> body)
            throws AttributeNotFoundException {
        int idUsuario = body.get("idUsuario");
        int idObra    = body.get("idObra");
        int cantidad  = body.getOrDefault("cantidad", 1);
        return ResponseEntity.ok(service.agregarItem(idUsuario, idObra, cantidad));
    }

    // PUT /api/carrito/actualizar
    // Body: { "idDetalle": 1, "cantidad": 2 }
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Map<String, Integer> body)
            throws AttributeNotFoundException {
        int idDetalle = body.get("idDetalle");
        int cantidad  = body.get("cantidad");
        CarritoDetalle detalle = service.actualizarCantidad(idDetalle, cantidad);
        if (detalle == null) return ResponseEntity.ok(Map.of("mensaje", "Item eliminado"));
        return ResponseEntity.ok(detalle);
    }

    // DELETE /api/carrito/item/{idDetalle}
    @DeleteMapping("/item/{idDetalle}")
    public ResponseEntity<Void> eliminarItem(@PathVariable int idDetalle)
            throws AttributeNotFoundException {
        service.eliminarItem(idDetalle);
        return ResponseEntity.noContent().build();
    }

    // DELETE /api/carrito/vaciar/{idUsuario}
    @DeleteMapping("/vaciar/{idUsuario}")
    public ResponseEntity<Void> vaciar(@PathVariable int idUsuario)
            throws AttributeNotFoundException {
        service.vaciarCarrito(idUsuario);
        return ResponseEntity.noContent().build();
    }
}

