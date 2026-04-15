package com.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> 1709edb (FINAL COMMIT)
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Obras;

@Repository
public interface ObraRepository extends JpaRepository<Obras, Integer> {
<<<<<<< HEAD
	List<Obras> findByCategoria_idCategoria(Integer idCategoria);
	List<Obras> findByTituloContainingIgnoreCase(String titulo);
	List<Obras> findByPrecio(float precio);
}
=======

    // Usar @Query porque el campo es id_categoria (con guion bajo)
    @Query("SELECT o FROM Obras o WHERE o.categoria.id_categoria = :idCategoria")
    List<Obras> findByCategoriaIdCategoria(@Param("idCategoria") Integer idCategoria);

    List<Obras> findByTituloContainingIgnoreCase(String titulo);

    List<Obras> findByPrecioBetween(float min, float max);
}
>>>>>>> 1709edb (FINAL COMMIT)
