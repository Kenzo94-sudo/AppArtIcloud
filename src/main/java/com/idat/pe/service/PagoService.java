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
	
	public Pago procesarPago(int idUsuario, Integer idPedido, MetodoPago metodoPago,
			String estado) throws AttributeNotFoundException {
		Usuarios usuarioPago = usuarioService.buscarPorId(idUsuario);
		Pedidos pedidoPago = pedidoService.buscarPorId(idPedido);
		if (pedidoPago.getUsuario().getId_usuario() != usuarioPago.getId_usuario()) {
		    throw new RuntimeException("El pedido no pertenece al usuario indicado");
		} 
		
		Pago pago = new Pago();
		pago.setUsuario(usuarioPago);
		pago.setPedido(pedidoPago);
		pago.setPrecio(pedidoPago.getTotal());
		pago.setMetodoPago(metodoPago);
		pago.setEstado(estado);
		
		Pago saved = repository.save(pago);
		return saved;
	}
	
	public Pago buscarPorId(int idPago) throws AttributeNotFoundException {
		return repository.findById(idPago).orElseThrow(() -> new AttributeNotFoundException("Pago no encontrado:" + idPago));
	}
	
	public List<Pago> listarPorUsuario(int idUsuario){
		return repository.findByUsuario_idUsuario(idUsuario);}
	
	public Pago buscarPorPedido(int idPedido) throws AttributeNotFoundException {
		return repository.findByPedido_idPedido(idPedido).orElseThrow(() -> new AttributeNotFoundException("Pago no encontrado para pedido:" + idPedido));
		}
	
}


