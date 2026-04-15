package com.idat.pe.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Obras;
import com.idat.pe.service.ObraService;
@RestController
@RequestMapping("/api/obras")
public class ObraController {
	
	@Autowired
	private ObraService service;
		
	@GetMapping("/listar")
	public List<Obras> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{idObra}")
	public ResponseEntity<Obras> listarPorId(@PathVariable int idObra) throws AttributeNotFoundException{
		Obras obra = service.buscarPorId(idObra);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/listar/categoria/{idCategoria}")
	public ResponseEntity<List<Obras>> buscarPorCategoria(@RequestParam int idCategoria) throws AttributeNotFoundException{
		List<Obras> obra = service.listarPorCategoria(idCategoria);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/listar/titulo/{titulo}")
	public ResponseEntity<List<Obras>> listarPorTitulo(@RequestParam String titulo) throws AttributeNotFoundException{
		List<Obras> obra = service.buscarPorTitulo(titulo);
		return ResponseEntity.ok(obra);
	}
	
	@GetMapping("/listar/precio/{precio}")
	public ResponseEntity<List<Obras>> buscarPorPrecio(@RequestParam float precio) throws AttributeNotFoundException{
		List<Obras> obra = service.filtrarPorPrecio(precio);
		return ResponseEntity.ok(obra);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Obras> guardarObras(@PathVariable Obras obra) throws AttributeNotFoundException{
		Obras obraGuardar = service.guardar(obra);
		return ResponseEntity.ok(obraGuardar);
	}
	
	@PutMapping("/actualizar/{idObra}")
	public ResponseEntity<Obras> actualizarObra(@PathVariable int idObra, @RequestParam Obras datos) throws AttributeNotFoundException{
		Obras obraActualizar = service.actualizar(idObra, datos);
		return ResponseEntity.ok(obraActualizar);
	}
	
	@DeleteMapping("/eliminar/{idObra}")
	public ResponseEntity<String> eliminarObra(@PathVariable int idObra) throws AttributeNotFoundException {
		service.eliminar(idObra);
		return ResponseEntity.ok("OBRA CON ID" + idObra + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
}
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.pe.model.Obras;
import com.idat.pe.service.ObraService;

@RestController
@RequestMapping("/api/obra")
@CrossOrigin(origins = "*")
public class ObraController {

    private final ObraService service;

    public ObraController(ObraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Obras> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obras> buscarPorId(@PathVariable int id) throws AttributeNotFoundException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Obras>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(service.buscarPorTitulo(titulo));
    }

    @GetMapping("/precio")
    public ResponseEntity<List<Obras>> buscarPorPrecio(
            @RequestParam float min,
            @RequestParam float max) {
        return ResponseEntity.ok(service.filtrarPorPrecio(min, max));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Obras>> listarPorCategoria(@PathVariable int id) {
        return ResponseEntity.ok(service.listarPorCategoria(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Obras> guardar(@RequestBody Obras obra) throws AttributeNotFoundException {
        return ResponseEntity.ok(service.guardar(obra));
    }
}
>>>>>>> 1709edb (FINAL COMMIT)
