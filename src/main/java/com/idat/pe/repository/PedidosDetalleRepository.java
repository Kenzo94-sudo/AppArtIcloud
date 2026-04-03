package com.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.PedidoDetalle;

@Repository
public interface PedidosDetalleRepository extends JpaRepository<PedidoDetalle, Integer>{
	List<PedidoDetalle> findByPedidoIdPedido (Integer id_pedido);
}
