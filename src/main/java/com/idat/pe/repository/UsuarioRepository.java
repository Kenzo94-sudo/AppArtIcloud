package com.idat.pe.repository;

import java.util.Optional;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> 1709edb (FINAL COMMIT)
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Usuarios;

@Repository
<<<<<<< HEAD
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
	
    Optional<Usuarios> findByEmail(String email);
    boolean existsByEmail(String email);
}
=======
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByEmail(String email);

    boolean existsByEmail(String email);
}
>>>>>>> 1709edb (FINAL COMMIT)
