package com.idat.pe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrito" )
	private int id_carrito;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuarios usuario;
	private java.util.Date fechaCompra;
	
	public Carrito() {}

	public Carrito(int id_carrito, Usuarios usuario, Date fechaCompra) {
		super();
		this.id_carrito = id_carrito;
		this.usuario = usuario;
		this.fechaCompra = fechaCompra;
	}

	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public java.util.Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(java.util.Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

		
	
}
