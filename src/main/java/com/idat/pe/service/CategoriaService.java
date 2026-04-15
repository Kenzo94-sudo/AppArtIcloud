package com.idat.pe.service;

import java.util.List;
<<<<<<< HEAD

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.function.Supplier;

import javax.management.AttributeNotFoundException;

>>>>>>> 1709edb (FINAL COMMIT)
import org.springframework.stereotype.Service;

import com.idat.pe.model.Categorias;
import com.idat.pe.repository.CategoriaRepository;

@Service
public class CategoriaService {
<<<<<<< HEAD
	@Autowired
=======
	
>>>>>>> 1709edb (FINAL COMMIT)
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public List<Categorias> listar() {
		return repository.findAll();
	}
	
<<<<<<< HEAD
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
=======
	public Categorias buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id)
		.orElseThrow( () -> new AttributeNotFoundException("Categoria no encontrada:" + id));
	}
	
	public Categorias guardar(Categorias c) 
	{ return repository.save(c);}
	
	public Categorias actualizar(int id, Categorias datos) throws AttributeNotFoundException {
		Categorias c = buscarPorId(id);
		c.setNombre(datos.getNombre());
		c.setDescripcion(datos.getDescripcion());
		return repository.save(c);
	}
	
	public void eliminar(int id) throws AttributeNotFoundException {
		buscarPorId(id);
		repository.deleteById(id);
>>>>>>> 1709edb (FINAL COMMIT)
	}
	
}
