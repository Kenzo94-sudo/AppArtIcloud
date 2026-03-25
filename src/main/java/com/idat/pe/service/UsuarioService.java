package com.idat.pe.service;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public List<Usuarios> listar(){
		return repository.findAll();
	}
	
	public Usuarios buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Usuario no encontrado" + id));
	}
	
	public Optional<Usuarios> buscarPorEmail(String email){
		return repository.findByEmail(email);
	}
	
	public Usuarios guardar(Usuarios u) {
		if(repository.existsByEmail(u.getEmail())) throw new
		RuntimeException("El email ya esta registrado");
		return repository.save(u);
	}
	
	public Usuarios actualizar(int id_usuario, Usuarios datos) throws AttributeNotFoundException {
		Usuarios u = buscarPorId(id_usuario);
		u.setNombre(datos.getNombre());
		u.setEmail(datos.getEmail());
		u.setDireccion(datos.getDireccion());
		u.setTelefono(datos.getTelefono());
		if(datos.getPassword() != null && !datos.getPassword().isBlank())
			u.setPassword(datos.getPassword());
		return repository.save(u);
	}
	
	public void elimninar(int id) throws AttributeNotFoundException {
		buscarPorId(id);
		repository.deleteById(id);
	}
}
