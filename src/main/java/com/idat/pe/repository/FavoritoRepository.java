package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
	// Busca todos los favoritos de un usuario
    List<Favorito> findByUsuario_idUsuario(int idUsuario);
    
    // Verifica si existe la combinación usuario + obra
    boolean existsByUsuario_idUsuarioAndObra_idObra(int idUsuario, int idObra);
    
    // Busca un favorito específico para poder eliminarlo
    Optional<Favorito> findByUsuario_idUsuarioAndObra_idObra(int idUsuario, int idObra);
}
