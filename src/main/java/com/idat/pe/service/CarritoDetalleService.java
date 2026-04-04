package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.CarritoDetalle;
import com.idat.pe.repository.CarritoDetalleRepository;

@Service
public class CarritoDetalleService {

		@Autowired
		private CarritoDetalleRepository repository;
				
		public CarritoDetalleService(CarritoDetalleRepository repository) {
			super();
			this.repository = repository;
		}

		public List<CarritoDetalle> listar()
		{
			return repository.findAll();
		}
		
		public CarritoDetalle buscarPorId(int idCarritoDetalle) 
		{
			return repository.findById(idCarritoDetalle)
					.orElseThrow(() -> new RuntimeException
					("Detalle no encontrado:" + idCarritoDetalle));}
		
		public CarritoDetalle listarPorCarrito(Integer idCarrito)
		{
			return repository.findByCarrito_idCarrito(idCarrito)
					.orElseThrow(() -> new RuntimeException
					("Carrito no encontrado:"+ idCarrito));
		}
		
		public CarritoDetalle guardarDetalle(CarritoDetalle carritoDetalle) {
			return repository.save(carritoDetalle);
		}
		
		public CarritoDetalle actualizar(int idCarritoDetalle, CarritoDetalle carritoDatos) 
		{
			CarritoDetalle carritoActualizar = buscarPorId(idCarritoDetalle);
			carritoActualizar.setId_detalle(carritoDatos.getId_detalle());
			carritoActualizar.setCarrito(carritoDatos.getCarrito());
			carritoActualizar.setObras(carritoDatos.getObras());
			carritoActualizar.setPrecio(carritoDatos.getPrecio());
			carritoActualizar.setCantidad(carritoDatos.getCantidad());
			return repository.save(carritoActualizar);
		}
		
		public void eliminar(int idCarritoDetalle) {
			buscarPorId(idCarritoDetalle);
			repository.deleteById(idCarritoDetalle);
		}
		
		
}
