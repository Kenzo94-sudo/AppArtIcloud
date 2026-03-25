package com.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
	List<Pedidos> findByUsuarioIdUsuario(Integer id_usuario);
}
