package com.idat.pe.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.DTO.PagoRequest;
import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pagos;
import com.idat.pe.model.Pedidos;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.PagoRepository;

import jakarta.transaction.Transactional;

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
	
	@Transactional
    public void procesarPago(PagoRequest dto) throws AttributeNotFoundException {
        // 1. Buscamos el pedido que se va a pagar
        Pedidos pedido = pedidoService.buscarPorId(dto.getIdPedido());

        // 2. Creamos el registro de pago (Entidad @Entity)
        Pagos pago = new Pagos();
        pago.setPedido(pedido);
        pago.setMonto(dto.getMonto());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setFechaPago(LocalDateTime.now());

        // 3. Guardamos el pago
        repository.save(pago);

        // 4. Actualizamos el estado del pedido
        pedido.setEstado("PAGADO");
        pedidoService.actualizar(pedido.getId_pedidos(), pedido);
    }
	
	public Pagos buscarPorId(int idPago) throws AttributeNotFoundException {
		return repository.findById(idPago).orElseThrow(() -> new AttributeNotFoundException("Pago no encontrado:" + idPago));
	}
	
	public List<Pagos> listarPorUsuario(int idUsuario){
		return repository.findByUsuario_idUsuario(idUsuario);}
	
	public Pagos buscarPorPedido(int idPedido) throws AttributeNotFoundException {
		return repository.findByPedido_idPedido(idPedido).orElseThrow(() -> new AttributeNotFoundException("Pago no encontrado para pedido:" + idPedido));
		}
	
}


