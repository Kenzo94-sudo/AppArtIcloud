package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Favorito;
import com.idat.pe.service.FavoritoService;

@RestController
@RequestMapping("/api/favorito")
public class FavoritoController {

		@Autowired
		private FavoritoService service;
		
		@GetMapping("/listar")
		public List<Favorito> listarFavorito()
		{
			return service.listar();
		}
		
		@PostMapping("/guardar")
		public Favorito guardar(@RequestBody Favorito favorito)
		{
			return service.guardarFavorito(favorito);
		}
		
		@DeleteMapping("/eliminar/{idFavorito}")
		public ResponseEntity<String> eliminarFavorito(@PathVariable int idFavorito)
		{
			service.eliminarFavorito(idFavorito);
			return ResponseEntity.ok("LA OBRA FAVORITA" +idFavorito + "HA SIDO ELIMINADO EXITOSAMENTE");
		}
}
