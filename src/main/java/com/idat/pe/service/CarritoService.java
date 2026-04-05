package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Carrito;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.CarritoRepository;

@Service
public class CarritoService {
	
	@Autowired
	private CarritoRepository repository;
	@Autowired
	private UsuarioService usuarioService;
	
	public CarritoService() {}
	
	public CarritoService(CarritoRepository repository, UsuarioService usuarioService) {
		super();
		this.repository = repository;
		this.usuarioService = usuarioService;
	}

	public List<Carrito> listar(){
		return repository.findAll();
	}
	
	public Carrito buscarPorId(Integer idCarrito) {
		return repository.findById(idCarrito)
				.orElseThrow(() -> new RuntimeException
						("Carrito no encontrado:" + idCarrito));}
	
	public Carrito buscarPorUsuario(Integer idUsuario) {
		return repository.findByUsuario_idUsuario(idUsuario).orElseThrow(() -> new RuntimeException
				("Usuario no encontrado:" + idUsuario));}
	
	public Carrito obtenerOCrear(int idUsuario) {
		return repository.findByUsuario_idUsuario(idUsuario).orElseGet(() -> {
			Usuarios usuario = null;
			try {
				usuario = usuarioService.buscarPorId(idUsuario);
			} catch (AttributeNotFoundException e) {
				e.printStackTrace();
			}
			Carrito nuevo = new Carrito();
			nuevo.setUsuario(usuario);
			return repository.save(nuevo);
		});
	}
		
	 public Carrito guardarCompra(Carrito carrito) {
		 return repository.save(carrito);
	 }
	
	 public void eliminar(int idCarrito) {
		 buscarPorId(idCarrito);
		 repository.deleteById(idCarrito);
	 }
}
