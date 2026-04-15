package com.idat.pe.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	    @Column(name = "idObra")
	    private int idObra;

	    private String titulo;

	    @Column(columnDefinition = "TEXT")
	    private String descripcion;

	    private float precio;

	    private int stock;

	    private String image_url;

	    @Column(name = "fechaRegistro", updatable = false)
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @CreationTimestamp
	    private LocalDateTime fechaRegistro;

	    @ManyToOne
	    @JoinColumn(name = "idCategoria")
	    private Categorias categoria;
	
	public Obras() {}

	public Obras(int idObra, String titulo, String descripcion, float precio, int stock, String image_url,
			LocalDateTime fechaRegistro, Categorias categoria) {
		super();
		this.idObra = idObra;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.image_url = image_url;
		this.fechaRegistro = fechaRegistro;
		this.categoria = categoria;
	}

	public int getId_obra() {
		return idObra;
	}

	public void setId_obra(int idObra) {
		this.idObra = idObra;
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

	public LocalDateTime getfechaRegistro() {
		return fechaRegistro;
	}

	public void setfechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}


}
