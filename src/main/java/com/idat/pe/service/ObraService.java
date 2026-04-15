package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 1709edb (FINAL COMMIT)
import org.springframework.stereotype.Service;

import com.idat.pe.model.Categorias;
import com.idat.pe.model.Obras;
import com.idat.pe.repository.ObraRepository;

@Service
public class ObraService {
<<<<<<< HEAD
	@Autowired
	private final ObraRepository repository;
	@Autowired
=======
	private final ObraRepository repository;
>>>>>>> 1709edb (FINAL COMMIT)
	private final CategoriaService categoriaService;
	
	public ObraService(ObraRepository repository, CategoriaService categoriaService) {
		this.repository = repository;
		this.categoriaService = categoriaService;
	}
	
	public List<Obras> listar() { return repository.findAll();}
	
<<<<<<< HEAD
	public Obras buscarPorId(int idObra) throws AttributeNotFoundException {
		return repository.findById(idObra).orElseThrow(() -> new AttributeNotFoundException("Obra no encontrada:" + idObra));}
	
	public List<Obras> listarPorCategoria(int idCategoria){
		return repository.findByCategoria_idCategoria(idCategoria);
=======
	public Obras buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Obra no encontrada:" + id));}
	

	public List<Obras> listarPorCategoria(int id_categoria){
		return repository.findByCategoriaIdCategoria(id_categoria);
>>>>>>> 1709edb (FINAL COMMIT)
		}
	
	public List<Obras> buscarPorTitulo(String titulo) {
		return repository.findByTituloContainingIgnoreCase(titulo);
	}
	
<<<<<<< HEAD
	public List<Obras> filtrarPorPrecio(float precio){
		return repository.findByPrecio(precio);}
=======
	public List<Obras> filtrarPorPrecio(float min, float max){
		return repository.findByPrecioBetween(min, max);}
>>>>>>> 1709edb (FINAL COMMIT)
		
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
<<<<<<< HEAD
	
	public Obras actualizar(int idObra, Obras obraDatos) throws AttributeNotFoundException {
		Obras obraActualizar = buscarPorId(idObra);
		obraActualizar.setId_obra(obraDatos.getId_obra());
		obraActualizar.setTitulo(obraDatos.getTitulo());
		obraActualizar.setPrecio(obraDatos.getPrecio());
		obraActualizar.setStock(obraDatos.getStock());
		obraActualizar.setImage_url(obraDatos.getImage_url());
		obraActualizar.setfechaRegistro(obraDatos.getfechaRegistro());
		obraActualizar.setDescripcion(obraDatos.getDescripcion());
		return repository.save(obraActualizar);
	}
	
	public void eliminar(int idObra) throws AttributeNotFoundException {
		buscarPorId(idObra);
		repository.deleteById(idObra);	}
	
	}
=======
	}
	
	
	
>>>>>>> 1709edb (FINAL COMMIT)
