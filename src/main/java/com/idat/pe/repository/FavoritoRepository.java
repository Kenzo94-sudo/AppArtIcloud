package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
	List<Favorito> findByUsuario_idUsuario(Integer idUsuario);
	Optional<Favorito> findByUsuario_idUsuarioAndObra_idObra(Integer idUsuario, Integer idObra);
	boolean existsByUsuario_idUsuarioAndObra_idObra(Integer idUsuario, Integer idObra);
	
	
}
