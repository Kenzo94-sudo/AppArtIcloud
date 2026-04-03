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
		
		public CarritoDetalle buscarPorId(int id_detalle) 
		{
			return repository.findById(id_detalle)
					.orElseThrow(() -> new RuntimeException
					("Detalle no encontrado:" + id_detalle));}
		
		public CarritoDetalle listarPorCarrito(Integer id_carrito)
		{
			return repository.findByCarritoIdCarrito(id_carrito)
					.orElseThrow(() -> new RuntimeException
					("Carrito no encontrado:"+ id_carrito));
		}
		
		public CarritoDetalle guardarDetalle(CarritoDetalle carritoDetalle) {
			return repository.save(carritoDetalle);
		}
		
		public CarritoDetalle actualizar(int id_detalle, CarritoDetalle datos) 
		{
			CarritoDetalle c = buscarPorId(id_detalle);
			c.setId_detalle(datos.getId_detalle());
			c.setCarrito(datos.getCarrito());
			c.setObras(datos.getObras());
			c.setPrecio(datos.getPrecio());
			c.setCantidad(datos.getCantidad());
			return repository.save(c);
		}
		
		public void eliminar(int id_detalle) {
			buscarPorId(id_detalle);
			repository.deleteById(id_detalle);
		}
		
		
}
