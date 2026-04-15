package com.idat.pe.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
	
    Optional<Usuarios> findByEmail(String email);
    boolean existsByEmail(String email);
}
