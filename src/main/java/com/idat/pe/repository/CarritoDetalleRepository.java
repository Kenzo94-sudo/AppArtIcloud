package com.idat.pe.repository;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
=======

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 1709edb (FINAL COMMIT)

import com.idat.pe.model.CarritoDetalle;

@Repository
public interface CarritoDetalleRepository extends JpaRepository<CarritoDetalle, Integer> {
<<<<<<< HEAD
	Optional<CarritoDetalle> findByCarrito_idCarrito(Integer idCarrito);
	void deleteByCarrito_idCarrito(Integer idCarrito);
}
=======

    @Query("SELECT cd FROM CarritoDetalle cd WHERE cd.carrito.id_carrito = :idCarrito")
    List<CarritoDetalle> findByCarritoIdCarrito(@Param("idCarrito") Integer idCarrito);

    @Modifying
    @Transactional
    @Query("DELETE FROM CarritoDetalle cd WHERE cd.carrito.id_carrito = :idCarrito")
    void deleteByCarritoIdCarrito(@Param("idCarrito") Integer idCarrito);
}
>>>>>>> 1709edb (FINAL COMMIT)
