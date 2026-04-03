package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Carrito;
@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
	Optional<Carrito> findByUsuarioIdUsuario(Integer id_usuario);
	Optional<Carrito> findById(Integer id_carrito);
	
}
