package com.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.CarritoDetalle;

@Repository
public interface CarritoDetalleRepository extends JpaRepository<CarritoDetalle, Integer> {
	List<CarritoDetalle> findByCarritoIdCarrito(Integer id_carrito);
	void deleteByCarritoIdCarrito(Integer id_carrito);
}
