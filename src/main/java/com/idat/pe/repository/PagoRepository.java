package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
	List<Pago> findByUsuario_idUsuario(Integer idUsuario);
	Optional<Pago> findByPedido_idPedido(Integer idPedido);
	List<Pago> findByMetodoPago(MetodoPago metodopago);
}
