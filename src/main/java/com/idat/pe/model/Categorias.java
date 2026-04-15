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
<<<<<<< HEAD
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idCategoria")
	    private Integer idCategoria;
	
	    @Column(nullable = false, length = 100)
	    private String nombre;
	
	    @Column(columnDefinition = "TEXT")
	    private String descripcion;
		
		public Categorias() {}

		public Categorias(Integer idCategoria, String nombre, String descripcion) {
			super();
			this.idCategoria = idCategoria;
=======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer id_categoria;
	private String nombre;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
		
		public Categorias() {}

		public Categorias(Integer id_categoria, String nombre, String descripcion) {
			super();
			this.id_categoria = id_categoria;
>>>>>>> 1709edb (FINAL COMMIT)
			this.nombre = nombre;
			this.descripcion = descripcion;
		}

		public Integer getId_categoria() {
<<<<<<< HEAD
			return idCategoria;
		}

		public void setId_categoria(Integer idCategoria) {
			this.idCategoria = idCategoria;
=======
			return id_categoria;
		}

		public void setId_categoria(Integer id_categoria) {
			this.id_categoria = id_categoria;
>>>>>>> 1709edb (FINAL COMMIT)
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
