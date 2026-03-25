package com.idat.pe.service;

import java.util.List;
import java.util.function.Supplier;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.idat.pe.model.Categorias;
import com.idat.pe.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public List<Categorias> listar() {
		return repository.findAll();
	}
	
	public Categorias buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id)
		.orElseThrow( () -> new AttributeNotFoundException("Categoria no encontrada:" + id));
	}
	
	public Categorias guardar(Categorias c) { return repository.save(c);}
	
	public Categorias actualizar(int id, Categorias datos) throws AttributeNotFoundException {
		Categorias c = buscarPorId(id);
		c.setNombre(datos.getNombre());
		c.setDescripcion(datos.getDescripcion());
		return repository.save(c);
	}
	
	public void eliminar(int id) throws AttributeNotFoundException {
		buscarPorId(id);
		repository.deleteById(id);
	}
	
}
