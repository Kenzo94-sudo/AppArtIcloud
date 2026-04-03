package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pago;
import com.idat.pe.model.Pedidos;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.PagoRepository;

@Service
public class PagoService {
	@Autowired
	private final PagoRepository repository;
	@Autowired
	private final PedidoService pedidoService;
	@Autowired
	private final UsuarioService usuarioService;
	
	
	public PagoService(PagoRepository repository,
			UsuarioService usuarioService, 
			PedidoService pedidoService){
		this.repository = repository;
		this.pedidoService = pedidoService;
		this.usuarioService = usuarioService;
	}
	
	public Pago procesarPago(int id_usuario, Integer id_pedido, MetodoPago metodoPago,
			String estado) throws AttributeNotFoundException {
		Usuarios usuario = usuarioService.buscarPorId(id_usuario);
		Pedidos pedido = pedidoService.buscarPorId(id_pedido);
		if (pedido.getUsuario().getId_usuario() != usuario.getId_usuario()) {
		    throw new RuntimeException("El pedido no pertenece al usuario indicado");
		} 
		
		Pago pago = new Pago();
		pago.setUsuario(usuario);
		pago.setPedido(pedido);
		pago.setPrecio(pedido.getTotal());
		pago.setMetodoPago(metodoPago);
		pago.setEstado(estado);
		
		Pago saved = repository.save(pago);
		return saved;
	}
	
	public Pago buscarPorId(int id) throws AttributeNotFoundException {
		return repository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Pago no encontrado:" + id));
	}
	
	public List<Pago> listarPorUsuario(int id_usuario){
		return repository.findByUsuarioIdUsuario(id_usuario);}
	
	public Pago buscarPorPedido(int id_pedido) throws AttributeNotFoundException {
		return repository.findByPedidoIdPedido(id_pedido).orElseThrow(() -> new AttributeNotFoundException("Pago no encontrado para pedido:" + id_pedido));
		}
	
}


