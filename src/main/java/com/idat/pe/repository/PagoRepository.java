package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pagos;

public interface PagoRepository extends JpaRepository<Pagos, Integer> {
	List<Pagos> findByUsuario_idUsuario(Integer idUsuario);
	Optional<Pagos> findByPedido_idPedido(Integer idPedido);
	List<Pagos> findByMetodoPago(MetodoPago metodopago);
}
