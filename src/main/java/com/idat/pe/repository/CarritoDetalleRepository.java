package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.CarritoDetalle;

@Repository
public interface CarritoDetalleRepository extends JpaRepository<CarritoDetalle, Integer> {
	Optional<CarritoDetalle> findByCarritoIdCarrito(Integer id_carrito);
	void deleteByCarritoIdCarrito(Integer id_carrito);
}
