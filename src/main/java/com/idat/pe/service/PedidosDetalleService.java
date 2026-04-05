package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.PedidoDetalle;
import com.idat.pe.repository.PedidosDetalleRepository;

@Service
public class PedidosDetalleService {
	@Autowired
	private PedidosDetalleRepository repository ;
		
	public PedidosDetalleService(PedidosDetalleRepository repository) {
		super();
		this.repository = repository;
	}

	public List<PedidoDetalle> listar() {
		return repository.findAll();
	}
	
	public PedidoDetalle buscarPorId(int idPedidoDetalle) throws AttributeNotFoundException {
		return repository.findById(idPedidoDetalle).orElseThrow(() -> new AttributeNotFoundException ("Detalle del Pedido no encontrado:" + idPedidoDetalle));
	}
	
	public PedidoDetalle guardarDetalle(PedidoDetalle pedidoDetalle) {
		return repository.save(pedidoDetalle);
	}
	
	public PedidoDetalle actualizarDetalle(int idPedidoDetalle, PedidoDetalle pedidoDatos) throws AttributeNotFoundException {
		PedidoDetalle pedidoDetalleActualizar = buscarPorId(idPedidoDetalle);
		pedidoDetalleActualizar.setId_detalle(pedidoDatos.getId_detalle());
		pedidoDetalleActualizar.setObra(pedidoDatos.getObra());
		pedidoDetalleActualizar.setPedido(pedidoDatos.getPedido());
		pedidoDetalleActualizar.setCantidad(pedidoDatos.getCantidad());
		pedidoDetalleActualizar.setPrecio(pedidoDatos.getPrecio());
		return repository.save(pedidoDetalleActualizar);
	}
	
	public void eliminar(int idPedidoDetalle) throws AttributeNotFoundException {
		buscarPorId(idPedidoDetalle);
		repository.deleteById(idPedidoDetalle);
	}
}
