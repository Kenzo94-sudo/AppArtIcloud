package com.idat.pe.service;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.DTO.RegisterRequest;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public List<Usuarios> listar(){
		return repository.findAll();
	}
	
	public Usuarios buscarPorId(int idUsuario) throws AttributeNotFoundException {
		return repository.findById(idUsuario).orElseThrow(() -> new AttributeNotFoundException("Usuario no encontrado" + idUsuario));
	}
	
	public Optional<Usuarios> buscarPorEmail(String email){
		return repository.findByEmail(email);
	}
	
	public Usuarios guardarUsuario(Usuarios usuario) {
		return repository.save(usuario);
	}
	
	public Usuarios registrarNuevoUsuario(RegisterRequest dto) {

	    Usuarios nuevoUsuario = new Usuarios();
	    nuevoUsuario.setNombre(dto.getNombre());
	    nuevoUsuario.setEmail(dto.getEmail()); 
	    nuevoUsuario.setPassword(dto.getPassword());
	    nuevoUsuario.setTelefono(dto.getTelefono());
	    nuevoUsuario.setDireccion(dto.getDireccion());
	    return repository.save(nuevoUsuario);
	}
	
	public Usuarios actualizar(int idUsuario, Usuarios usuarioDatos) throws AttributeNotFoundException {
		Usuarios usuarioActualizar = buscarPorId(idUsuario);
		usuarioActualizar.setNombre(usuarioDatos.getNombre());
		usuarioActualizar.setEmail(usuarioDatos.getEmail());
		usuarioActualizar.setDireccion(usuarioDatos.getDireccion());
		usuarioActualizar.setTelefono(usuarioDatos.getTelefono());
		if(usuarioDatos.getPassword() != null && !usuarioDatos.getPassword().isBlank())
			usuarioActualizar.setPassword(usuarioDatos.getPassword());
		return repository.save(usuarioActualizar);
	}
	
	public void eliminar(int idUsuario) throws AttributeNotFoundException {
		buscarPorId(idUsuario);
		repository.deleteById(idUsuario);
	}
	
	//Para el AuthController
	public Usuarios autenticar(String email, String password) {
	    Usuarios usuario = repository.findByEmail(email)
	        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	    if (!usuario.getPassword().equals(password))
	        throw new RuntimeException("Contraseña incorrecta");
	    return usuario;
	}
}
