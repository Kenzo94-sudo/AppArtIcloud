package com.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Obras;

@Repository
public interface ObraRepository extends JpaRepository<Obras, Integer> {
	List<Obras> findByCategoriaIdCategoria(Integer id_categoria);
	List<Obras> findByTituloContainingIgnoreCase(String titulo);
	List<Obras> findByPrecioBetween(float min, float max);
}
