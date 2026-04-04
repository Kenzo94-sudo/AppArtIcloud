package com.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoria")
	private Integer idCategoria;
	private String nombre;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
		
		public Categorias() {}

		public Categorias(Integer idCategoria, String nombre, String descripcion) {
			super();
			this.idCategoria = idCategoria;
			this.nombre = nombre;
			this.descripcion = descripcion;
		}

		public Integer getId_categoria() {
			return idCategoria;
		}

		public void setId_categoria(Integer idCategoria) {
			this.idCategoria = idCategoria;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}	
}
