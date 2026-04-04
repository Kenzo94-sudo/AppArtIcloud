package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Categorias;
import com.idat.pe.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public List<Categorias> listar() {
		return repository.findAll();
	}
	
	public Categorias buscarPorId(int idCategoria) throws AttributeNotFoundException {
		return repository.findById(idCategoria)
		.orElseThrow( () -> new AttributeNotFoundException("Categoria no encontrada:" + idCategoria));
	}
	
	public Categorias guardar(Categorias categoria) 
	{ return repository.save(categoria);}
	
	public Categorias actualizar(int idCategoria, Categorias categoriaDatos) throws AttributeNotFoundException {
		Categorias categoriaActualizar = buscarPorId(idCategoria);
		categoriaActualizar.setNombre(categoriaDatos.getNombre());
		categoriaActualizar.setDescripcion(categoriaDatos.getDescripcion());
		return repository.save(categoriaActualizar);
	}
	
	public void eliminar(int idCategoria) throws AttributeNotFoundException {
		buscarPorId(idCategoria);
		repository.deleteById(idCategoria);
	}
	
}
