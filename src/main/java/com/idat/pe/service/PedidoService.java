package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.idat.pe.model.Obras;
import com.idat.pe.model.Pedidos;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.PedidosRepository;

@Service
public class PedidoService {
	
	private final PedidosRepository repository;
	private final UsuarioService usuarioService;
	private final ObraService obraService;
	
	public PedidoService(PedidosRepository repository, 
			UsuarioService usuarioService, ObraService obraService)
	{
		this.repository = repository;
		this.usuarioService = usuarioService;
		this.obraService = obraService;
	}
	
	public List<Pedidos> listar() { return repository.findAll();}
	
	public Pedidos buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id).orElseThrow(() 
				-> new AttributeNotFoundException("Pedido no encontrado:" + id));}
	

	public List<Pedidos> listarPorUsuario(int id_usuario){
		return repository.findByUsuarioIdUsuario(id_usuario);}
	
	public Pedidos crear(int id_usuario, int id_obra) throws AttributeNotFoundException {
		Usuarios usuario = usuarioService.buscarPorId(id_usuario);
		Obras obra = obraService.buscarPorId(id_obra);
		Pedidos pedido = new Pedidos();
		pedido.setUsuario(usuario);
		pedido.setObra(obra);
		pedido.setTotal(obra.getPrecio());
		return repository.save(pedido);}
	
	public Pedidos actualizar(int id_pedido, Pedidos datos) throws AttributeNotFoundException {
		Pedidos pedido = buscarPorId(id_pedido);
		pedido.setId_pedidos(datos.getId_pedidos());
		pedido.setObra(datos.getObra());
		pedido.setUsuario(datos.getUsuario());
		pedido.setTotal(datos.getTotal());
		pedido.setFechaPedido(datos.getFechaPedido());
		pedido.setEstado(datos.getEstado());
		return repository.save(pedido);
	}
	
	public void eliminar(int id) throws AttributeNotFoundException {
		buscarPorId(id);
		repository.deleteById(id);
	}

}
