package com.idat.pe.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.PedidoDetalle;

@Repository
public interface PedidosDetalleRepository extends JpaRepository<PedidoDetalle, Integer>{
	List<PedidoDetalle> findByPedido_idPedido (Integer idPedido);
=======
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosDetalleRepository{

>>>>>>> 1709edb (FINAL COMMIT)
}
