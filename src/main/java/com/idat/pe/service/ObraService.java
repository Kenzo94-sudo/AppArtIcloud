package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.idat.pe.model.Categorias;
import com.idat.pe.model.Obras;
import com.idat.pe.repository.ObraRepository;

@Service
public class ObraService {
	private final ObraRepository repository;
	private final CategoriaService categoriaService;
	
	public ObraService(ObraRepository repository, CategoriaService categoriaService) {
		this.repository = repository;
		this.categoriaService = categoriaService;
	}
	
	public List<Obras> listar() { return repository.findAll();}
	
	public Obras buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Obra no encontrada:" + id));}
	

	public List<Obras> listarPorCategoria(int id_categoria){
		return repository.findByCategoriaIdCategoria(id_categoria);
		}
	
	public List<Obras> buscarPorTitulo(String titulo) {
		return repository.findByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Obras> filtrarPorPrecio(float min, float max){
		return repository.findByPrecioBetween(min, max);}
		
	public Obras guardar(Obras o) throws AttributeNotFoundException {

	    if (o.getCategoria() != null && o.getCategoria().getId_categoria() > 0) {

	        Categorias cat = categoriaService.buscarPorId(o.getCategoria().getId_categoria());

	        if (cat == null) {
	            throw new RuntimeException("Categoría no encontrada");
	        }

	        o.setCategoria(cat);
	    }

	    return repository.save(o);
	}
	}
	
	
	
