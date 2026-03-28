package com.idat.pe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "obras")
public class Obras {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obra")
	private int id_obra;
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	private float precio;
	private int stock;
	private String image_url;
	@Column(name = "fecha_creacion")
	private java.util.Date fechaCreacion;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categorias categoria;
	
	public Obras() {
		
	}

	public Obras(int id_obra, String titulo, String descripcion, float precio, int stock, String image_url,
			Date fechaCreacion, Categorias categoria) {
		super();
		this.id_obra = id_obra;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.image_url = image_url;
		this.fechaCreacion = fechaCreacion;
		this.categoria = categoria;
	}

	public int getId_obra() {
		return id_obra;
	}

	public void setId_obra(int id_obra) {
		this.id_obra = id_obra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public java.util.Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(java.util.Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

}
