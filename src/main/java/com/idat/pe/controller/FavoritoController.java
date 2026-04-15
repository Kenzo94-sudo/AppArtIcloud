package com.idat.pe.controller;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD

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
=======
import java.util.stream.Collectors;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.pe.model.Favorito;
import com.idat.pe.model.Obras;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.FavoritoRepository;
import com.idat.pe.service.ObraService;
import com.idat.pe.service.UsuarioService;

@RestController
@RequestMapping("/api/favorito")
@CrossOrigin(origins = "*")
public class FavoritoController {

    private final FavoritoRepository repository;
    private final UsuarioService usuarioService;
    private final ObraService obraService;

    public FavoritoController(FavoritoRepository repository,
                               UsuarioService usuarioService,
                               ObraService obraService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.obraService = obraService;
    }

    // GET /api/favorito/usuario/{id} → devuelve lista de Obras
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Obras>> listarPorUsuario(@PathVariable int id) {
        List<Favorito> favoritos = repository.findByUsuarioIdUsuario(id);
        List<Obras> obras = favoritos.stream()
            .map(Favorito::getObra)
            .collect(Collectors.toList());
        return ResponseEntity.ok(obras);
    }

    // POST /api/favorito/toggle
    @PostMapping("/toggle")
    public ResponseEntity<Map<String, Object>> toggle(@RequestBody Map<String, Integer> body)
            throws AttributeNotFoundException {
        int idUsuario = body.get("idUsuario");
        int idObra    = body.get("idObra");

        boolean exists = repository.existsByUsuarioIdUsuarioAndObraIdObra(idUsuario, idObra);

        if (exists) {
            repository.findByUsuarioIdUsuarioAndObraIdObra(idUsuario, idObra)
                .ifPresent(repository::delete);
            return ResponseEntity.ok(Map.of("accion", "eliminado", "esFavorito", false));
        } else {
            Usuarios usuario = usuarioService.buscarPorId(idUsuario);
            Obras obra = obraService.buscarPorId(idObra);
            Favorito favorito = new Favorito();
            favorito.setUsuario(usuario);
            favorito.setObra(obra);
            favorito.setFecha(new java.util.Date());
            repository.save(favorito);
            return ResponseEntity.ok(Map.of("accion", "agregado", "esFavorito", true));
        }
    }

    // GET /api/favorito/check?idUsuario=1&idObra=2
    @GetMapping("/check")
    public ResponseEntity<Map<String, Boolean>> check(
            @RequestParam int idUsuario,
            @RequestParam int idObra) {
        boolean esFavorito = repository.existsByUsuarioIdUsuarioAndObraIdObra(idUsuario, idObra);
        return ResponseEntity.ok(Map.of("esFavorito", esFavorito));
    }
}
>>>>>>> 1709edb (FINAL COMMIT)
