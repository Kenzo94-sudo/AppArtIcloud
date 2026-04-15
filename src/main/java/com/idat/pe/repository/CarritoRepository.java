package com.idat.pe.repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Carrito;
@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
	Optional<Carrito> findByUsuario_idUsuario(Integer idUsuario);
	Optional<Carrito> findById(Integer idCarrito);
}
=======
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    @Query("SELECT c FROM Carrito c WHERE c.usuario.id_usuario = :idUsuario")
    Optional<Carrito> findByUsuarioIdUsuario(@Param("idUsuario") Integer idUsuario);
}
>>>>>>> 1709edb (FINAL COMMIT)
