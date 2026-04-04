package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Obras;
import com.idat.pe.model.Pedidos;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.PedidosRepository;

@Service
public class PedidoService {
	@Autowired
	private final PedidosRepository repository;
	@Autowired
	private final UsuarioService usuarioService;
	@Autowired
	private final ObraService obraService;
	
	public PedidoService(PedidosRepository repository, 
			UsuarioService usuarioService, ObraService obraService)
	{
		this.repository = repository;
		this.usuarioService = usuarioService;
		this.obraService = obraService;
	}
	
	public List<Pedidos> listar() { return repository.findAll();}
	
	public Pedidos buscarPorId(int idPedido) throws AttributeNotFoundException {
		return repository.findById(idPedido).orElseThrow(() 
				-> new AttributeNotFoundException("Pedido no encontrado:" + idPedido));}
	

	public List<Pedidos> listarPorUsuario(int idUsuario){
		return repository.findByUsuario_idUsuario(idUsuario);}
	
	public Pedidos crear(int idUsuario, int idObra) throws AttributeNotFoundException {
		Usuarios usuario = usuarioService.buscarPorId(idUsuario);
		Obras obra = obraService.buscarPorId(idObra);
		Pedidos pedido = new Pedidos();
		pedido.setUsuario(usuario);
		pedido.setObra(obra);
		pedido.setTotal(obra.getPrecio());
		return repository.save(pedido);}
	
	public Pedidos actualizar(int idPedido, Pedidos pedidoDatos) throws AttributeNotFoundException {
		Pedidos pedidoActualizar = buscarPorId(idPedido);
		pedidoActualizar.setId_pedidos(pedidoDatos.getId_pedidos());
		pedidoActualizar.setObra(pedidoDatos.getObra());
		pedidoActualizar.setUsuario(pedidoDatos.getUsuario());
		pedidoActualizar.setTotal(pedidoDatos.getTotal());
		pedidoActualizar.setFechaPedido(pedidoDatos.getFechaPedido());
		pedidoActualizar.setEstado(pedidoDatos.getEstado());
		return repository.save(pedidoActualizar);
	}
	
	public void eliminar(int idPedido) throws AttributeNotFoundException {
		buscarPorId(idPedido);
		repository.deleteById(idPedido);
	}

}
