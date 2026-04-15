package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pagos;

public interface PagoRepository extends JpaRepository<Pagos, Integer> {
	List<Pagos> findByUsuario_idUsuario(Integer idUsuario);
	Optional<Pagos> findByPedido_idPedido(Integer idPedido);
	List<Pagos> findByMetodoPago(MetodoPago metodopago);
}
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idat.pe.model.MetodoPago;
import com.idat.pe.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    @Query("SELECT p FROM Pago p WHERE p.usuario.id_usuario = :idUsuario")
    List<Pago> findByUsuarioIdUsuario(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT p FROM Pago p WHERE p.pedido.id_pedidos = :idPedido")
    Optional<Pago> findByPedidoIdPedido(@Param("idPedido") Integer idPedido);

    List<Pago> findByMetodoPago(MetodoPago metodopago);
}
>>>>>>> 1709edb (FINAL COMMIT)
