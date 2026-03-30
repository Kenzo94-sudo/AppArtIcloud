package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
	List<Pago> findByUsuarioIdUsuario(Integer id_usuario);
	Optional<Pago> findByPedidoIdPedido(Integer id_pedido);
	List<Pago> findByMetodoPago(MetodoPago metodopago);
}
