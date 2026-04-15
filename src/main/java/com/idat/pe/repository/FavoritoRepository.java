package com.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> 1709edb (FINAL COMMIT)

import com.idat.pe.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
<<<<<<< HEAD
	// Busca todos los favoritos de un usuario
    List<Favorito> findByUsuario_idUsuario(int idUsuario);
    
    // Verifica si existe la combinación usuario + obra
    boolean existsByUsuario_idUsuarioAndObra_idObra(int idUsuario, int idObra);
    
    // Busca un favorito específico para poder eliminarlo
    Optional<Favorito> findByUsuario_idUsuarioAndObra_idObra(int idUsuario, int idObra);
}
=======

    @Query("SELECT f FROM Favorito f WHERE f.usuario.id_usuario = :idUsuario")
    List<Favorito> findByUsuarioIdUsuario(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT f FROM Favorito f WHERE f.usuario.id_usuario = :idUsuario AND f.obra.id_obra = :idObra")
    Optional<Favorito> findByUsuarioIdUsuarioAndObraIdObra(
        @Param("idUsuario") Integer idUsuario,
        @Param("idObra") Integer idObra);

    @Query("SELECT COUNT(f) > 0 FROM Favorito f WHERE f.usuario.id_usuario = :idUsuario AND f.obra.id_obra = :idObra")
    boolean existsByUsuarioIdUsuarioAndObraIdObra(
        @Param("idUsuario") Integer idUsuario,
        @Param("idObra") Integer idObra);
}
>>>>>>> 1709edb (FINAL COMMIT)
