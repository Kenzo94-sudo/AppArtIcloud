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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Categorias;
import com.idat.pe.service.CategoriaService;
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	
	@GetMapping("/listar")
	public List<Categorias> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{idCategoria}")
	public ResponseEntity<Categorias> listarPorId(@PathVariable int idCategoria) throws AttributeNotFoundException{
		Categorias categoria = service.buscarPorId(idCategoria);
		return ResponseEntity.ok(categoria);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Categorias> guardarCategoria(@PathVariable Categorias idCategoria) throws AttributeNotFoundException{
		Categorias categoria = service.guardar(idCategoria);
		return ResponseEntity.ok(categoria);
	}
	
	@PutMapping("/actualizar/{idCategoria}")
	public ResponseEntity<Categorias> actualizarCategoria(@PathVariable int idCategoria, @RequestBody Categorias categoriaDatos) throws AttributeNotFoundException{
		Categorias categoria = service.actualizar(idCategoria, categoriaDatos);
		return ResponseEntity.ok(categoria);
	}
	
	@DeleteMapping("/eliminar/{idCategoria}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable int idCategoria) throws AttributeNotFoundException{
		service.eliminar(idCategoria);
		return ResponseEntity.ok("LA CATEGORIA DE LA OBRA" + idCategoria + "HA SIDO ELIMINADO EXITOSAMENTE");
	}
}
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.pe.model.Categorias;
import com.idat.pe.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categorias> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> buscarPorId(@PathVariable int id) throws AttributeNotFoundException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Categorias> guardar(@RequestBody Categorias categoria) {
        return ResponseEntity.ok(service.guardar(categoria));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Categorias> actualizar(@PathVariable int id, @RequestBody Categorias datos)
            throws AttributeNotFoundException {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) throws AttributeNotFoundException {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
>>>>>>> 1709edb (FINAL COMMIT)
