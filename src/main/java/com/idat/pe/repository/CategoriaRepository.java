package com.idat.pe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Integer>{}
