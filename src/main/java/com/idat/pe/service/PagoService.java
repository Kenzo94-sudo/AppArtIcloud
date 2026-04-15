package com.idat.pe.service;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Date;
=======
>>>>>>> 1709edb (FINAL COMMIT)
import java.util.List;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.DTO.PagoRequest;
import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pagos;
=======
import org.springframework.stereotype.Service;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pago;
>>>>>>> 1709edb (FINAL COMMIT)
import com.idat.pe.model.Pedidos;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.PagoRepository;

<<<<<<< HEAD
import jakarta.transaction.Transactional;

@Service
public class PagoService {
	@Autowired
	private final PagoRepository repository;
	@Autowired
	private final PedidoService pedidoService;
	@Autowired
=======
@Service
public class PagoService {
	private final PagoRepository repository;
	private final PedidoService pedidoService;
>>>>>>> 1709edb (FINAL COMMIT)
	private final UsuarioService usuarioService;
	
	
	public PagoService(PagoRepository repository,
			UsuarioService usuarioService, 
			PedidoService pedidoService){
		this.repository = repository;
		this.pedidoService = pedidoService;
		this.usuarioService = usuarioService;
	}
	
<<<<<<< HEAD
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
	
=======
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
>>>>>>> 1709edb (FINAL COMMIT)
}


