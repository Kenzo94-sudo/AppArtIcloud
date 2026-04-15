package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.DTO.PedidoDetalleRequest;
import com.idat.pe.DTO.PedidoRequest;
import com.idat.pe.model.Obras;
import com.idat.pe.model.PedidoDetalle;
import com.idat.pe.model.Pedidos;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.PedidosDetalleRepository;
import com.idat.pe.repository.PedidosRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
	@Autowired
	private final  PedidosRepository repository;
	@Autowired
	private final UsuarioService usuarioService;
	@Autowired
	private final ObraService obraService;
	private PedidosDetalleRepository detalleRepository;
	
	public PedidoService(PedidosRepository repository, 
			UsuarioService usuarioService, ObraService obraService, PedidosDetalleRepository detalleRepository)
=======
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
>>>>>>> 1709edb (FINAL COMMIT)
	{
		this.repository = repository;
		this.usuarioService = usuarioService;
		this.obraService = obraService;
<<<<<<< HEAD
		this.detalleRepository = detalleRepository;
=======
>>>>>>> 1709edb (FINAL COMMIT)
	}
	
	public List<Pedidos> listar() { return repository.findAll();}
	
<<<<<<< HEAD
	public Pedidos buscarPorId(int idPedido) throws AttributeNotFoundException {
		return repository.findById(idPedido).orElseThrow(() 
				-> new AttributeNotFoundException("Pedido no encontrado:" + idPedido));}
	

	public List<Pedidos> listarPorUsuario(int idUsuario){
		return repository.findByUsuario_idUsuario(idUsuario);}
	
	@Transactional
	public Pedidos procesarPedidoCompleto(PedidoRequest dto) throws AttributeNotFoundException {
	    // 1. Buscar al Usuario (Validación)
	    Usuarios usuario = usuarioService.buscarPorId(dto.getIdUsuario());

	    // 2. Crear la Cabecera del Pedido
	    Pedidos nuevoPedido = new Pedidos();
	    nuevoPedido.setUsuario(usuario);
	    nuevoPedido.setTotal(dto.getTotal());
	    nuevoPedido.setEstado("PAGADO");
	    nuevoPedido.setFechaPedido(java.time.LocalDateTime.now());

	    // 3. GUARDAR CABECERA: Aquí obtenemos el ID autoincremental
	    Pedidos pedidoGuardado = repository.save(nuevoPedido);

	    // 4. GUARDAR DETALLES: Recorremos la lista que viene de Android
	    for (PedidoDetalleRequest itemDto : dto.getDetalle()) {
	        PedidoDetalle detalle = new PedidoDetalle();
	        
	        // Vinculamos el detalle con el pedido que acabamos de guardar
	        detalle.setPedido(pedidoGuardado); 
	        
	        // Buscamos la obra por ID
	        Obras obra = obraService.buscarPorId(itemDto.getIdObra());
	        detalle.setObra(obra);
	        
	        detalle.setCantidad(itemDto.getCantidad());
	        detalle.setPrecio(itemDto.getPrecio());

	        // Guardamos el detalle (necesitarás inyectar DetalleRepository)
	        detalleRepository.save(detalle);
	    }

	    return pedidoGuardado;
	}
	
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

=======
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
	
	public void eliminar(int id) throws AttributeNotFoundException {
		buscarPorId(id);
		repository.deleteById(id);
	}
>>>>>>> 1709edb (FINAL COMMIT)
}
