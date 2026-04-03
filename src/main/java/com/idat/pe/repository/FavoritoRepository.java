package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
	List<Favorito> findByUsuarioIdUsuario(Integer id_usuario);
	Optional<Favorito> findByUsuarioIdUsuarioAndObraIdObra(Integer id_usuario, Integer id_obra);
	boolean existsByUsuarioIdUsuarioAndObraIdObra(Integer id_usuario, Integer id_obra);
	
	
}
