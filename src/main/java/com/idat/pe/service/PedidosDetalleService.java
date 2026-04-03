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
	
	public PedidoDetalle buscarPorId(int id_detalle) throws AttributeNotFoundException {
		return repository.findById(id_detalle).orElseThrow(() -> new AttributeNotFoundException ("Detalle del Pedido no encontrado:" + id_detalle));
	}
	
	public PedidoDetalle guardarDetalle(PedidoDetalle detalle) {
		return repository.save(detalle);
	}
	
	public PedidoDetalle actualizarDetalle(int id_pedido, PedidoDetalle datos) throws AttributeNotFoundException {
		PedidoDetalle detalle = buscarPorId(id_pedido);
		detalle.setId_detalle(datos.getId_detalle());
		detalle.setObra(datos.getObra());
		detalle.setPedido(datos.getPedido());
		detalle.setCantidad(datos.getCantidad());
		detalle.setPrecio(datos.getPrecio());
		return repository.save(detalle);
	}
	
	public void eliminar(int id_pedido) throws AttributeNotFoundException {
		buscarPorId(id_pedido);
		repository.deleteById(id_pedido);
	}
}
