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
	
	public Carrito buscarPorId(Integer id_carrito) {
		return repository.findById(id_carrito)
				.orElseThrow(() -> new RuntimeException
						("Carrito no encontrado:" + id_carrito));}
	
	public Carrito buscarPorUsuario(Integer id_usuario) {
		return repository.findByUsuarioIdUsuario(id_usuario).orElseThrow(() -> new RuntimeException
				("Usuario no encontrado:" + id_usuario));}
	
	public Carrito obtenerOCrear(int id_usuario) {
		return repository.findByUsuarioIdUsuario(id_usuario).orElseGet(() -> {
			Usuarios usuario = null;
			try {
				usuario = usuarioService.buscarPorId(id_usuario);
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
	
	 public void eliminar(int id) {
		 buscarPorId(id);
		 repository.deleteById(id);
	 }
}
