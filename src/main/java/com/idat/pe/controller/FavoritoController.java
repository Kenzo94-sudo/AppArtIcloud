package com.idat.pe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.DTO.FavoritoRequest;
import com.idat.pe.model.Favorito;
import com.idat.pe.service.FavoritoService;

@RestController
@RequestMapping("/api/favorito")
public class FavoritoController {

	  @Autowired
	    private FavoritoService service;

	  @GetMapping("/listar/{idUsuario}")
	    public ResponseEntity<List<Favorito>> listar(@PathVariable int idUsuario) {
	        return ResponseEntity.ok(service.listarPorUsuario(idUsuario));
	    }

	  @PostMapping("/agregar")
	    public ResponseEntity<?> agregar(@RequestBody FavoritoRequest request) {
	        try {
	            return ResponseEntity.ok(service.agregarAFavoritos(request));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

	    // DELETE /api/favoritos/eliminar
	    @DeleteMapping("/eliminar")
	    public ResponseEntity<String> eliminar(@RequestBody Map<String, Integer> body) {
	        service.eliminar(
	            body.get("idUsuario"),
	            body.get("idObra")
	        );
	        return ResponseEntity.ok("Eliminado de favoritos");
	    }

	    // GET /api/favoritos/verificar?idUsuario=1&idObra=3
	    @GetMapping("/verificar")
	    public ResponseEntity<Boolean> verificar(
	        @RequestParam int idUsuario,
	        @RequestParam int idObra
	    ) {
	        return ResponseEntity.ok(service.esFavorito(idUsuario, idObra));
	    }
	}