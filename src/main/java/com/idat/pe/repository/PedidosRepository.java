package com.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> 1709edb (FINAL COMMIT)

import com.idat.pe.model.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
<<<<<<< HEAD
	List<Pedidos> findByUsuario_idUsuario(Integer idUsuario);
}
=======

    @Query("SELECT p FROM Pedidos p WHERE p.usuario.id_usuario = :idUsuario")
    List<Pedidos> findByUsuarioIdUsuario(@Param("idUsuario") Integer idUsuario);
}
>>>>>>> 1709edb (FINAL COMMIT)
